package com.selles.ifindit.core.viewmodel

import androidx.lifecycle.LiveData
import com.selles.ifindit.core.viewmodel.plugins.ViewModelPlugins

class Action<Action : UIAction> {

    private val _action: OneShotLiveData<Action> = ViewModelPlugins.factory.createOneShotLiveData()
    val action: LiveData<Action> = _action

    fun sendAction(action: () -> Action) {
        _action.value = action()
    }
}