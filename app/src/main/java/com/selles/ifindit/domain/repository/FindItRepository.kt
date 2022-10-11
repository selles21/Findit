package com.selles.ifindit.domain.repository

import com.selles.ifindit.domain.entity.ITunesSearch
import kotlinx.coroutines.flow.Flow

internal interface FindItRepository {
    fun getITunesSearch(filter: String): Flow<ITunesSearch>
}