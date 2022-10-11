package com.selles.ifindit.data.extension

import com.selles.ifindit.data.model.response.ITunesSearchResponse
import com.selles.ifindit.data.model.response.ResultResponse
import com.selles.ifindit.domain.entity.ITunesSearch
import com.selles.ifindit.domain.entity.SearchResult

internal fun ITunesSearchResponse.toItunesSearch(): ITunesSearch {
    return ITunesSearch(
        resultCount = this.resultCount,
        results = this.results?.map {
            toSearchResult(it)
        }
    )
}

internal fun toSearchResult(resultResponse: ResultResponse?): SearchResult {
    return SearchResult(
        artistId = resultResponse?.artistId,
        artistName = resultResponse?.artistName,
        artistViewUrl = resultResponse?.artistViewUrl,
        artworkUrl100 = resultResponse?.artworkUrl100,
        artworkUrl30 = resultResponse?.artworkUrl30,
        artworkUrl60 = resultResponse?.artworkUrl60,
        collectionCensoredName = resultResponse?.collectionCensoredName,
        collectionExplicitness = resultResponse?.collectionExplicitness,
        collectionId = resultResponse?.collectionId,
        collectionName = resultResponse?.collectionName,
        collectionPrice = resultResponse?.collectionPrice,
        collectionViewUrl = resultResponse?.collectionViewUrl,
        country = resultResponse?.country,
        currency = resultResponse?.currency,
        discCount = resultResponse?.discCount,
        discNumber = resultResponse?.discNumber,
        isStreamable = resultResponse?.isStreamable,
        kind = resultResponse?.kind,
        previewUrl = resultResponse?.previewUrl,
        primaryGenreName = resultResponse?.primaryGenreName,
        releaseDate = resultResponse?.releaseDate,
        trackCensoredName = resultResponse?.trackCensoredName,
        trackCount = resultResponse?.trackCount,
        trackExplicitness = resultResponse?.trackExplicitness,
        trackId = resultResponse?.trackId,
        trackName = resultResponse?.trackName,
        trackNumber = resultResponse?.trackNumber,
        trackPrice = resultResponse?.trackPrice,
        trackTimeMillis = resultResponse?.trackTimeMillis,
        trackViewUrl = resultResponse?.trackViewUrl,
        wrapperType = resultResponse?.wrapperType
    )
}