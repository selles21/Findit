package com.selles.ifindit.domain.entity


internal data class ITunesSearch(
    val resultCount: Int? = 0,
    val results: List<SearchResult?>? = listOf()
)