package com.selles.ifindit.presentation.viewmodel

import android.media.MediaPlayer
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.selles.ifindit.core.coroutines.CoroutineTestRule
import com.selles.ifindit.core.test.ViewModelRule
import com.selles.ifindit.domain.usecase.GetITunesSearchUseCase
import com.selles.ifindit.presentation.viewmodel.action.FindItAction
import com.selles.ifindit.presentation.viewmodel.state.FindItState
import com.selles.ifindit.utils.FindItHelperTest
import io.mockk.coEvery
import io.mockk.coVerifyOrder
import io.mockk.mockk
import io.mockk.verifyOrder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
internal class FindItViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val viewModelRule = ViewModelRule(
        stateObserver = mockk(relaxed = true),
        actionObserver = mockk(relaxed = true)
    )

    private lateinit var viewModel: FindItViewModel
    private val getITunesSearchUseCase = mockk<GetITunesSearchUseCase>()
    private val mediaPlayer = mockk<MediaPlayer>()
    private lateinit var stateObserver: Observer<FindItState>
    private lateinit var actionObserver: Observer<FindItAction>

    @Test
    fun `searchData Should return success state`() = runBlocking {
        //Given
        val initStateExpected = FindItState()
        val startStateExpected = initStateExpected.copy(isLoading = true, haveNoData = false)
        val endStateExpected = initStateExpected.copy(
            isLoading = false,
            haveNoData = false,
            searchResult = listOf(FindItHelperTest.result),
            quantity = 1
        )

        coEvery { getITunesSearchUseCase("Johnson") } returns flow { emit(FindItHelperTest.iTunesSearch) }

        //When
        createViewModel()
        viewModel.searchData("Johnson")

        //Then
        coVerifyOrder {
            stateObserver.onChanged(initStateExpected)
            stateObserver.onChanged(startStateExpected)
            stateObserver.onChanged(endStateExpected)
        }

    }

    @Test
    fun `openExternalUrl Should send OpenExternalUrl action`() {
        //Given
        createViewModel()

        //When
        viewModel.openExternalUrl("")

        //Then
        verifyOrder {
            actionObserver.onChanged(
                FindItAction.OpenExternalUrl("")
            )
        }
    }

    private fun createViewModel() {
        viewModel = FindItViewModel(
            getITunesSearchUseCase,
            mediaPlayer,
            coroutineTestRule.testDispatcher
        )
        stateObserver = viewModelRule.getStateObserver()
        actionObserver = viewModelRule.getActionObserver()
    }
}