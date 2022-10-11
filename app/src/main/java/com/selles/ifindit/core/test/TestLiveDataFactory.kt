package com.selles.ifindit.core.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.selles.ifindit.core.viewmodel.OneShotLiveData
import com.selles.ifindit.core.viewmodel.UIAction
import com.selles.ifindit.core.viewmodel.UIState
import com.selles.ifindit.core.viewmodel.plugins.LiveDataFactory

internal class TestLiveDataFactory(
    val stateObserver: Observer<UIState>,
    val actionObserver: Observer<UIAction>
) : LiveDataFactory {
    override fun <T : UIState> createMutableLiveData(initialState: T): MutableLiveData<T> =
        MutableLiveData(initialState).apply {
            observeForever(stateObserver as Observer<T>)
        }

    override fun <T : UIAction> createOneShotLiveData(): OneShotLiveData<T> =
        OneShotLiveData<T>().apply {
            observeForever(actionObserver as Observer<T>)
        }


}