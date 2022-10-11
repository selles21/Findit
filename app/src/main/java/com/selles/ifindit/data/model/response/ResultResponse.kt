package com.selles.ifindit.data.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ResultResponse(
    @SerialName("artistId")
    val artistId: Int? = 0,
    @SerialName("artistName")
    val artistName: String? = "",
    @SerialName("artistViewUrl")
    val artistViewUrl: String? = "",
    @SerialName("artworkUrl100")
    val artworkUrl100: String? = "",
    @SerialName("artworkUrl30")
    val artworkUrl30: String? = "",
    @SerialName("artworkUrl60")
    val artworkUrl60: String? = "",
    @SerialName("collectionCensoredName")
    val collectionCensoredName: String? = "",
    @SerialName("collectionExplicitness")
    val collectionExplicitness: String? = "",
    @SerialName("collectionId")
    val collectionId: Int? = 0,
    @SerialName("collectionName")
    val collectionName: String? = "",
    @SerialName("collectionPrice")
    val collectionPrice: Double? = 0.0,
    @SerialName("collectionViewUrl")
    val collectionViewUrl: String? = "",
    @SerialName("country")
    val country: String? = "",
    @SerialName("currency")
    val currency: String? = "",
    @SerialName("discCount")
    val discCount: Int? = 0,
    @SerialName("discNumber")
    val discNumber: Int? = 0,
    @SerialName("isStreamable")
    val isStreamable: Boolean? = false,
    @SerialName("kind")
    val kind: String? = "",
    @SerialName("previewUrl")
    val previewUrl: String? = "",
    @SerialName("primaryGenreName")
    val primaryGenreName: String? = "",
    @SerialName("releaseDate")
    val releaseDate: String? = "",
    @SerialName("trackCensoredName")
    val trackCensoredName: String? = "",
    @SerialName("trackCount")
    val trackCount: Int? = 0,
    @SerialName("trackExplicitness")
    val trackExplicitness: String? = "",
    @SerialName("trackId")
    val trackId: Int? = 0,
    @SerialName("trackName")
    val trackName: String? = "",
    @SerialName("trackNumber")
    val trackNumber: Int? = 0,
    @SerialName("trackPrice")
    val trackPrice: Double? = 0.0,
    @SerialName("trackTimeMillis")
    val trackTimeMillis: Int? = 0,
    @SerialName("trackViewUrl")
    val trackViewUrl: String? = "",
    @SerialName("wrapperType")
    val wrapperType: String? = ""
)