package com.selles.ifindit.core.viewmodel

import androidx.lifecycle.ViewModel

abstract class DisposableViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
    }
}