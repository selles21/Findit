package com.selles.ifindit.data.mapper

import com.selles.ifindit.data.model.response.ITunesSearchResponse
import com.selles.ifindit.domain.entity.ITunesSearch

internal class ITunesSearchMapper(
    private val seachMapper: SearchResultMapper
) : Mapper<ITunesSearchResponse, ITunesSearch> {
    override fun map(entry: ITunesSearchResponse): ITunesSearch {
        return ITunesSearch(
            resultCount = entry.resultCount,
            results = entry.results.run(seachMapper::map)
        )
    }
}