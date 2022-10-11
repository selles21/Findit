package com.selles.ifindit.core.viewmodel.plugins

import androidx.lifecycle.MutableLiveData
import com.selles.ifindit.core.viewmodel.OneShotLiveData
import com.selles.ifindit.core.viewmodel.UIAction
import com.selles.ifindit.core.viewmodel.UIState

interface LiveDataFactory {

    fun <T : UIState> createMutableLiveData(initialState: T): MutableLiveData<T>

    fun <T : UIAction> createOneShotLiveData(): OneShotLiveData<T>
}