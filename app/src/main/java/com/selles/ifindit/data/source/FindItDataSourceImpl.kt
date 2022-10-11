package com.selles.ifindit.data.source

import com.selles.ifindit.data.api.FindItService
import com.selles.ifindit.data.error.parseHttpError
import com.selles.ifindit.data.model.response.ITunesSearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class FindItDataSourceImpl(private val findItService: FindItService) : FindItDataSource {
    override fun getITunesSearch(filter: String): Flow<ITunesSearchResponse> = flow {
        emit(findItService.getITunesSearch(filter, "music", "song", ""))
    }.parseHttpError()
}