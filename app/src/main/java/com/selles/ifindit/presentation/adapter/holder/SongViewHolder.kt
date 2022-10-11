package com.selles.ifindit.presentation.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.selles.ifindit.databinding.FinditSongCardBinding
import com.selles.ifindit.domain.entity.SearchResult

internal class SongViewHolder(
    private val binding: FinditSongCardBinding,
    private val onItemSelected: (Int) -> Unit,
    private val onArtistSelected: (String) -> Unit,
    private val onCollectionSelected: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(searchResult: SearchResult, position: Int) {
        setupView(searchResult, position)
    }

    private fun setupView(searchResult: SearchResult, position: Int) {
        with(binding.songCard) {
            imageUrl = searchResult.artworkUrl100
            trackName = searchResult.trackName
            artistName = searchResult.artistName
            artistViewUrl = searchResult.artistViewUrl
            collectionName = searchResult.collectionName
            collectionViewUrl = searchResult.collectionViewUrl
            genreName = searchResult.primaryGenreName
            isStreamable = searchResult.isStreamable

            openDetailListener(onItemSelected, position)
            openArtistClickListener(onArtistSelected)
            openCollectionClickListener(onCollectionSelected)
        }
    }
}