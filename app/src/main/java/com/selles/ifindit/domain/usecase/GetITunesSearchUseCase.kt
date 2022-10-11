package com.selles.ifindit.domain.usecase

import com.selles.ifindit.domain.entity.ITunesSearch
import com.selles.ifindit.domain.repository.FindItRepository
import kotlinx.coroutines.flow.Flow

internal class GetITunesSearchUseCase(private val findItRepository: FindItRepository) {

    operator fun invoke(filter: String): Flow<ITunesSearch> = findItRepository.getITunesSearch(filter)
}