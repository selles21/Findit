package com.selles.ifindit.presentation.adapter.factory

import androidx.recyclerview.widget.RecyclerView
import com.selles.ifindit.domain.entity.SearchResult

internal interface Card {

    fun create(): RecyclerView.ViewHolder

    fun getCardType(): String
}