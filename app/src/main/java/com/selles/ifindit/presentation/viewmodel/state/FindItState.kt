package com.selles.ifindit.presentation.viewmodel.state

import com.selles.ifindit.core.viewmodel.UIState
import com.selles.ifindit.domain.entity.SearchResult

internal data class FindItState(
    val isLoading: Boolean = false,
    val haveNoData: Boolean = true,
    val searchResult: List<SearchResult?>? = null,
    val selectedElement: SearchResult? = null,
    val quantity: Int? = 0,
    val error: Throwable? = null
) : UIState
