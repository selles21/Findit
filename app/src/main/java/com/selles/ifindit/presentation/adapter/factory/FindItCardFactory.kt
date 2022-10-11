package com.selles.ifindit.presentation.adapter.factory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.selles.ifindit.databinding.FinditSongCardBinding
import com.selles.ifindit.presentation.adapter.holder.SongViewHolder
import java.lang.IllegalArgumentException

internal class FindItCardFactory(
    private val onItemSelected: (Int) -> Unit,
    private val onArtistSelected: (String) -> Unit,
    private val onCollectionSelected: (String) -> Unit
) {

    fun inflate(parent: ViewGroup, type: String): RecyclerView.ViewHolder {
        return when (type) {
            "song" -> {
                val binding = FinditSongCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                SongViewHolder(binding, onItemSelected, onArtistSelected, onCollectionSelected)
            }
            else -> throw IllegalArgumentException("ViewHolder not yet definet")
        }
    }

}