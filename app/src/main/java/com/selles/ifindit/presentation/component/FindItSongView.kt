package com.selles.ifindit.presentation.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import com.selles.ifindit.R
import com.selles.ifindit.databinding.FinditSongViewBinding
import com.selles.ifindit.presentation.extension.loadImage

internal class FindItSongView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAt: Int = 0
) : ConstraintLayout(context, attrs, defStyleAt) {

    private val binding = FinditSongViewBinding.inflate(LayoutInflater.from(context), this, true)

    var imageUrl: String? = null
        set(value) {
            field = value
            binding.artworkUrlImageView.loadImage(context, value ?: "")
        }

    var trackName: String? = null
        set(value) {
            field = value
            binding.trackNameTextView.text = value
        }

    var artistName: String? = null
        set(value) {
            field = value
            binding.artistNameTextView.text = value
        }

    var artistViewUrl: String? = null
        set(value) {
            field = value
        }

    var collectionViewUrl: String? = null
        set(value) {
            field = value
        }

    var collectionName: String? = null
        set(value) {
            field = value
            binding.collectionNameTextView.text = value
        }

    var genreName: String? = null
        set(value) {
            field = value
            binding.genreChip.text = value
        }

    var isStreamable: Boolean? = false
        set(value) {
            field = value
            binding.streamChip.isChecked = value ?: false
            binding.streamChip.setChipStrokeColorResource(R.color.teal_700)
        }

    init {
        parseAttrs(context, attrs)
    }

    private fun parseAttrs(context: Context, attrs: AttributeSet?) {
        context.withStyledAttributes(attrs, R.styleable.FindItSongView) {
            imageUrl = getString(R.styleable.FindItSongView_finditImageUrl).orEmpty()
            trackName = getString(R.styleable.FindItSongView_finditTrackName).orEmpty()
            artistName = getString(R.styleable.FindItSongView_finditArtistName).orEmpty()
            collectionName = getString(R.styleable.FindItSongView_finditCollectionName).orEmpty()
            genreName = getString(R.styleable.FindItSongView_finditGenreName).orEmpty()
        }
    }

    fun openDetailListener(action: ((Int) -> Unit)? = null, position: Int) {
        binding.component.setOnClickListener {
            action?.invoke(position)
        }
    }

    fun openArtistClickListener(action: ((String) -> Unit)? = null) {
        binding.artistNameTextView.setOnClickListener {
            artistViewUrl?.let {
                action?.invoke(artistViewUrl!!)
            }
        }
    }

    fun openCollectionClickListener(action: ((String) -> Unit)? = null) {
        binding.collectionNameTextView.setOnClickListener {
            collectionViewUrl?.let {
                action?.invoke(collectionViewUrl!!)
            }
        }
    }
}