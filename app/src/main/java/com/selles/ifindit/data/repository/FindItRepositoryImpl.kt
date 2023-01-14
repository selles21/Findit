package com.selles.ifindit.data.repository

import com.selles.ifindit.data.mapper.ITunesSearchMapper
import com.selles.ifindit.data.source.FindItDataSource
import com.selles.ifindit.domain.entity.ITunesSearch
import com.selles.ifindit.domain.repository.FindItRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class FindItRepositoryImpl(
    private val findItDataSource: FindItDataSource,
    private val iTunesMapper: ITunesSearchMapper
) :
    FindItRepository {
    override fun getITunesSearch(filter: String): Flow<ITunesSearch> {
        return findItDataSource.getITunesSearch(filter).map {
            it.run(iTunesMapper::map)
        }
    }
}