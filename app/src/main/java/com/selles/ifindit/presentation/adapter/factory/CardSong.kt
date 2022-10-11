package com.selles.ifindit.presentation.adapter.factory

import androidx.recyclerview.widget.RecyclerView
import com.selles.ifindit.databinding.FinditSongCardBinding
import com.selles.ifindit.presentation.adapter.holder.SongViewHolder

internal class CardSong(
    private val binding: FinditSongCardBinding,
    private val onItemSelected: (Int) -> Unit,
    private val onArtistSelected: (String) -> Unit,
    private val onCollectionSelected: (String) -> Unit
) : Card {
    private val type = "song"

    override fun create(): RecyclerView.ViewHolder {
        return SongViewHolder(
            binding,
            onItemSelected,
            onArtistSelected,
            onCollectionSelected
        )
    }

    override fun getCardType(): String {
        return type
    }
}