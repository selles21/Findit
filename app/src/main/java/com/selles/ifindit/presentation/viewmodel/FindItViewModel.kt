package com.selles.ifindit.presentation.viewmodel

import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.lifecycle.viewModelScope
import com.selles.ifindit.R
import com.selles.ifindit.core.viewmodel.ViewModel
import com.selles.ifindit.domain.entity.ITunesSearch
import com.selles.ifindit.domain.entity.SearchResult
import com.selles.ifindit.domain.usecase.GetITunesSearchUseCase
import com.selles.ifindit.presentation.viewmodel.action.FindItAction
import com.selles.ifindit.presentation.viewmodel.state.FindItState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.net.URLEncoder

private const val UTF8 = "utf-8"

internal class FindItViewModel(
    private val findItUseCase: GetITunesSearchUseCase,
    private val mediaPlayer: MediaPlayer,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel<FindItState, FindItAction>(FindItState()) {

    var _results: List<SearchResult?>? = emptyList()
    val results get() = _results!!

    fun searchData(filter: String) {
        val encoded = URLEncoder.encode(filter, UTF8)
        viewModelScope.launch {
            findItUseCase.invoke(encoded)
                .flowOn(dispatcher)
                .onStart {
                    setState {
                        it.copy(
                            isLoading = true,
                            haveNoData = false
                        )
                    }
                }
                .onCompletion { setState { it.copy(isLoading = false) } }
                .catch {
                    getHandlerError(it)
                }
                .collect {
                    buildStateSuccess(it)
                }
        }
    }

    private fun buildStateSuccess(iTunesSearch: ITunesSearch) {
        _results = iTunesSearch.results
        setState {
            it.copy(
                error = null,
                searchResult = iTunesSearch.results,
                quantity = iTunesSearch.resultCount,
                haveNoData = (iTunesSearch.resultCount?.compareTo(0) == 0)
            )
        }
    }

    private fun getHandlerError(error: Throwable) {
        sendAction {
            FindItAction.ShowErrorMessage(R.string.app_name)
        }
    }

    fun selectElement(position: Int) {
        setState {
            it.copy(
                selectedElement = _results?.get(position)
            )
        }
    }

    fun playPreview(previewUrl: String?) {
        if (mediaPlayer.isPlaying.not())
            previewUrl?.let {
                mediaPlayer.apply {
                    reset()
                    setDataSource(previewUrl)
                    prepare()
                    start()
                }
            }
        else
            mediaPlayer.stop()


    }

    fun navigateToDetails(position: Int) {
        selectElement(position)
        sendAction {
            FindItAction.NavigateToDetails(position)
        }
    }

    fun openExternalUrl(externalUrl: String) {
        sendAction {
            FindItAction.OpenExternalUrl(externalUrl)
        }
    }

    fun clearData() {
        setState {
            FindItState()
        }
    }
}