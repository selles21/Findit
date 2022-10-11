package com.selles.ifindit.core.viewmodel.plugins

object ViewModelPlugins {
    var factory: LiveDataFactory = DefaultLiveDataFactory()
        private set

    fun setFactory(factory: LiveDataFactory) {
        ViewModelPlugins.factory = factory
    }
}