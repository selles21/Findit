package com.selles.ifindit.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.button.MaterialButton
import com.selles.ifindit.R
import com.selles.ifindit.databinding.FragmentDetailBinding
import com.selles.ifindit.domain.entity.SearchResult
import com.selles.ifindit.presentation.extension.*
import com.selles.ifindit.presentation.viewmodel.FindItViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FindItViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt("position")

        setupNavigation()
        stateViewModelListener()
        actionViewModelListener()
    }

    private fun actionViewModelListener() = onAction(viewModel) {

    }

    private fun stateViewModelListener() = onStateChange(viewModel) { state ->
        loadElement(state.selectedElement)
    }

    private fun loadElement(selectedElement: SearchResult?) = with(binding) {
        selectedElement?.let {
            trackNameTextView.text = "${it.trackName} (${it.trackTimeMillis?.toMinutes()})"
            artistNameTextView.text = it.artistName
            collectionNameTextView.text = it.collectionName
            genreYearTextview.text =
                getString(R.string.genre_year, it.primaryGenreName, it.releaseDate?.getYear())
            setupPreview(previewButton, it.previewUrl)
            setupAddToCard(buyButton, it.trackPrice, it.currency)
            setupShare(shareButton, it.trackViewUrl)
            val artworkUrl300 = it.artworkUrl100?.replace("100x100", "300x300")
            artworkUrlImageView.loadImage(requireContext(), artworkUrl300 ?: "")
        }
    }

    private fun setupAddToCard(buyButton: MaterialButton, trackPrice: Double?, currency: String?) {
        buyButton.setOnClickListener {
            openToast("${trackPrice?.toRidePrice(currency)}")
        }
    }

    private fun setupShare(shareButton: MaterialButton, trackViewUrl: String?) {
        shareButton.setOnClickListener {
            shareElement(trackViewUrl)
        }
    }

    private fun setupPreview(previewButton: MaterialButton, previewUrl: String?) {
        previewButton.setOnClickListener {
            viewModel.playPreview(previewUrl)
        }
    }

    private fun setupNavigation() {
        val navController = findNavController()
        val appBarConfig = AppBarConfiguration(navController.graph)
        val toolbar: Toolbar = binding.toolBarLayout

        toolbar.setupWithNavController(navController, appBarConfig)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}