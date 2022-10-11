package com.selles.ifindit.core.viewmodel

import androidx.lifecycle.LiveData

abstract class ViewModel<State : UIState, Action : UIAction>(
    initialState: State
) : DisposableViewModel() {

    private val viewModelState = State(initialState)
    private val viewModelAction = Action<Action>()

    val state: LiveData<State> = viewModelState.state
    val action: LiveData<Action> = viewModelAction.action

    protected fun setState(state: (State) -> State) {
        viewModelState.setState(state)
    }

    protected fun sendAction(action: () -> Action) {
        viewModelAction.sendAction(action)
    }
}