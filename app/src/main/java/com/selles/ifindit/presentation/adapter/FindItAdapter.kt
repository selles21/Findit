package com.selles.ifindit.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.selles.ifindit.databinding.FinditSongCardBinding
import com.selles.ifindit.domain.entity.SearchResult
import com.selles.ifindit.presentation.adapter.factory.CardSong
import com.selles.ifindit.presentation.adapter.factory.FindItCardFactory
import com.selles.ifindit.presentation.adapter.holder.SongViewHolder

internal class FindItAdapter(
    private val onItemSelected: (Int) -> Unit,
    private val onArtistSelected: (String) -> Unit,
    private val onCollectionSelected: (String) -> Unit
) : ListAdapter<SearchResult, RecyclerView.ViewHolder>(DefaultDiffCallback()) {

    private val factory by lazy {
        FindItCardFactory(
            onItemSelected, onArtistSelected, onCollectionSelected
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = FinditSongCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CardSong(binding, onItemSelected, onArtistSelected, onCollectionSelected).create()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SongViewHolder).bind(
            getItem(position),
            position
        )
    }
}


internal class DefaultDiffCallback<T : Any> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

}