package com.selles.ifindit.data.mapper

import com.selles.ifindit.data.model.response.ResultResponse
import com.selles.ifindit.domain.entity.SearchResult

internal class SearchResultMapper : Mapper<List<ResultResponse?>?, List<SearchResult>?> {
    override fun map(entries: List<ResultResponse?>?): List<SearchResult>? {
        return entries?.mapNotNull { entry ->
            SearchResult(
                artistId = entry?.artistId,
                artistName = entry?.artistName,
                artistViewUrl = entry?.artistViewUrl,
                artworkUrl30 = entry?.artworkUrl30,
                artworkUrl60 = entry?.artworkUrl60,
                artworkUrl100 = entry?.artworkUrl100,
                collectionCensoredName = entry?.collectionCensoredName,
                collectionExplicitness = entry?.collectionExplicitness,
                collectionId = entry?.collectionId,
                collectionName = entry?.collectionName,
                collectionPrice = entry?.collectionPrice,
                collectionViewUrl = entry?.collectionViewUrl,
                country = entry?.country,
                currency = entry?.currency,
                discCount = entry?.discCount,
                discNumber = entry?.discNumber,
                isStreamable = entry?.isStreamable,
                kind = entry?.kind,
                previewUrl = entry?.previewUrl,
                primaryGenreName = entry?.primaryGenreName,
                releaseDate = entry?.releaseDate,
                trackCensoredName = entry?.trackCensoredName,
                trackCount = entry?.trackCount,
                trackExplicitness = entry?.trackExplicitness,
                trackId = entry?.trackId,
                trackName = entry?.trackName,
                trackNumber = entry?.trackNumber,
                trackPrice = entry?.trackPrice,
                trackTimeMillis = entry?.trackTimeMillis,
                trackViewUrl = entry?.trackViewUrl,
                wrapperType = entry?.wrapperType
            )
        }
    }
}