package com.selles.ifindit.core.viewmodel

import androidx.lifecycle.LiveData
import com.selles.ifindit.core.viewmodel.plugins.ViewModelPlugins

class State<State : UIState>(initialState: State) {

    private val _state = ViewModelPlugins.factory.createMutableLiveData(initialState)
    val state: LiveData<State> = _state

    fun setState(state: (State) -> State) {
        _state.value = state(_state.value!!)
    }
}