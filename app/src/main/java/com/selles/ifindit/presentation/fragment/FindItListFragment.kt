package com.selles.ifindit.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.selles.ifindit.R
import com.selles.ifindit.databinding.FragmentFinditListBinding
import com.selles.ifindit.domain.entity.SearchResult
import com.selles.ifindit.presentation.adapter.FindItAdapter
import com.selles.ifindit.presentation.extension.*
import com.selles.ifindit.presentation.viewmodel.FindItViewModel
import com.selles.ifindit.presentation.viewmodel.action.FindItAction
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FindItListFragment : Fragment(R.layout.fragment_findit_list) {

    private lateinit var sheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var bottomSheetLayout: ConstraintLayout
    private var _binding: FragmentFinditListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FindItViewModel by sharedViewModel()

    private val adapterSearch by lazy {
        FindItAdapter(
            onItemSelected = { position -> viewModel.navigateToDetails(position) },
            onArtistSelected = { artistUrl -> viewModel.openExternalUrl(artistUrl) },
            onCollectionSelected = { collectionUrl -> viewModel.openExternalUrl(collectionUrl) }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFinditListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupButton()
        setupFab()
        setupBottomSheet()
        stateViewModelListener()
        actionViewModelListener()
    }

    private fun setupFab() = with(binding) {
        fab.setOnClickListener { view ->
            toggleBottomSheet()
        }
    }

    private fun setupBottomSheet() = with(binding) {
        sheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)

        searchButton.setOnClickListener {
            commonActions(it)
            viewModel.searchData(labelTextView.text.toString())
        }
        clearButton.setOnClickListener {
            commonActions(it)
            viewModel.clearData()
        }

    }

    private fun commonActions(view: View) {
        view.hideKeyboard()
        toggleBottomSheet()
    }

    private fun toggleBottomSheet() {
        sheetBehavior.toggle()
    }

    private fun setupButton() {
        binding.newSearchButton.setOnClickListener {
            toggleBottomSheet()
        }
    }

    private fun setupRecyclerView() = with(binding.findItRecyclerView) {
        addItemDecoration(
            DividerItemDecoration(
                this.context,
                LinearLayout.VERTICAL
            )
        )
        adapter = adapterSearch
    }

    private fun stateViewModelListener() = onStateChange(viewModel) { state ->
        isLoading(state.isLoading)
        haveNoData(state.haveNoData)
        setupSearch(state.searchResult, state.quantity)
    }

    private fun actionViewModelListener() = onAction(viewModel) { action ->
        when (action) {
            is FindItAction.NavigateToDetails -> navigateToDetails(action.position)
            is FindItAction.OpenExternalUrl -> openExternalUrl(action.externalUrl)
            is FindItAction.ShowErrorMessage -> showErrorMessage(action.messageRes)
            else -> showErrorMessage(R.string.common_error)
        }

    }

    private fun haveNoData(hasNoData: Boolean) = with(binding) {
        noDataGroup.isVisible = hasNoData
        findItRecyclerView.isVisible = hasNoData.not()
        fab.isVisible = hasNoData.not()
    }

    private fun setupSearch(searchResult: List<SearchResult?>?, quantity: Int?) {
        adapterSearch.submitList(searchResult)
    }

    private fun isLoading(loading: Boolean) {
        binding.searchingProgress.isVisible = loading
    }

    private fun showErrorMessage(messageRes: Int) {
        return
    }

    private fun navigateToDetails(position: Int) {
        viewModel.selectElement(position)
        val bundle = bundleOf("position" to position)
        findNavController().navigate(R.id.action_FindItFragment_to_DetailFragment, bundle)
    }

    private fun openExternalUrl(externalnUrl: String) {
        openExternalLink(externalnUrl)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}