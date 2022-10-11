package com.selles.ifindit.domain.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchResult(
    val artistId: Int? = 0,
    val artistName: String? = "",
    val artistViewUrl: String? = "",
    val artworkUrl100: String? = "",
    val artworkUrl30: String? = "",
    val artworkUrl60: String? = "",
    val collectionCensoredName: String? = "",
    val collectionExplicitness: String? = "",
    val collectionId: Int? = 0,
    val collectionName: String? = "",
    val collectionPrice: Double? = 0.0,
    val collectionViewUrl: String? = "",
    val country: String? = "",
    val currency: String? = "",
    val discCount: Int? = 0,
    val discNumber: Int? = 0,
    val isStreamable: Boolean? = false,
    val kind: String? = "",
    val previewUrl: String? = "",
    val primaryGenreName: String? = "",
    val releaseDate: String? = "",
    val trackCensoredName: String? = "",
    val trackCount: Int? = 0,
    val trackExplicitness: String? = "",
    val trackId: Int? = 0,
    val trackName: String? = "",
    val trackNumber: Int? = 0,
    val trackPrice: Double? = 0.0,
    val trackTimeMillis: Int? = 0,
    val trackViewUrl: String? = "",
    val wrapperType: String? = ""
)