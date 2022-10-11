package com.selles.ifindit.data.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ITunesSearchResponse(
    @SerialName("resultCount")
    val resultCount: Int? = 0,
    @SerialName("results")
    val results: List<ResultResponse?>? = listOf()
)