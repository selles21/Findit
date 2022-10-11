package com.selles.ifindit.data.source

import com.selles.ifindit.data.model.response.ITunesSearchResponse
import kotlinx.coroutines.flow.Flow

internal interface FindItDataSource {

    fun getITunesSearch(filter: String):Flow<ITunesSearchResponse>
}