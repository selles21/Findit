package com.selles.ifindit.presentation.viewmodel.action

import androidx.annotation.StringRes
import com.selles.ifindit.core.viewmodel.UIAction
import com.selles.ifindit.domain.entity.SearchResult

internal sealed class FindItAction : UIAction {

    data class OpenElement(val searchResult: SearchResult) : FindItAction()
    data class OpenExternalUrl(val externalUrl: String) : FindItAction()
    data class NavigateToDetails(val position: Int) : FindItAction()
    data class ShowErrorMessage(@StringRes val messageRes: Int) : FindItAction()
}
