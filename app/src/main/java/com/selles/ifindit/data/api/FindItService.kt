package com.selles.ifindit.data.api

import com.selles.ifindit.data.model.response.ITunesSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface FindItService {

    @KSerialization
    @GET("/search")
    suspend fun getITunesSearch(
        @Query("term") term: String,
        @Query("media") media: String,
        @Query("entity") entity: String,
        @Query("attribute") attribute: String,
        @Query("limit") limit: Int = 15
    ): ITunesSearchResponse
}

@Retention(AnnotationRetention.RUNTIME)
annotation class KSerialization