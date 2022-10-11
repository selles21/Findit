package com.selles.ifindit.core.viewmodel.plugins

import androidx.lifecycle.MutableLiveData
import com.selles.ifindit.core.viewmodel.OneShotLiveData
import com.selles.ifindit.core.viewmodel.UIAction
import com.selles.ifindit.core.viewmodel.UIState

class DefaultLiveDataFactory : LiveDataFactory {
    override fun <T : UIState> createMutableLiveData(initialState: T): MutableLiveData<T> {
        return MutableLiveData(initialState)
    }

    override fun <T : UIAction> createOneShotLiveData() = OneShotLiveData<T>()
}