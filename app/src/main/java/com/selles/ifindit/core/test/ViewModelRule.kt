package com.selles.ifindit.core.test

import androidx.lifecycle.Observer
import com.selles.ifindit.core.viewmodel.UIAction
import com.selles.ifindit.core.viewmodel.UIState
import io.mockk.mockk
import org.junit.rules.ExternalResource

@Suppress("UNCHECKED_CAST")
class ViewModelRule(
    stateObserver: Observer<UIState> = mockk(),
    actionObserver: Observer<UIAction> = mockk()
) : ExternalResource() {
    private val factory = TestLiveDataFactory(stateObserver, actionObserver)

    fun <T : UIState> getStateObserver():Observer<T>{
        try {
            return factory.stateObserver as Observer<T>
        }catch (e: UninitializedPropertyAccessException){
            val message = "'getStateObserver()' should be called after ViewModel initialization"
            throw ViewModelTestRuleException(message, e)
        }
    }

    fun <T : UIAction> getActionObserver():Observer<T>{
        try {
            return factory.actionObserver as Observer<T>
        }catch (e: UninitializedPropertyAccessException){
            val message = "'getActionObserver()' should be called after ViewModel initialization"
            throw ViewModelTestRuleException(message, e)
        }
    }

}