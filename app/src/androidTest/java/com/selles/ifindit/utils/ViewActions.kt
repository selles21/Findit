package com.selles.ifindit.utils

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf

object ViewActions {

    fun performAction(@IdRes resId: Int, action: ViewAction) {
        performAction(allOf(withId(resId), isDisplayed()), action)
    }

    fun performAction(matcher: Matcher<View>, action: ViewAction) {
        onView(matcher).perform(action)
    }

    fun performClick(text: String) {
        onView(allOf(withText(text), isDisplayed())).perform(click())
    }

    fun performClick(@IdRes resId: Int) {
        onView(allOf(withId(resId), isDisplayed())).perform(click())
    }

    fun performType(@IdRes resId: Int, text: String) {
        onView(withId(resId)).perform(typeText(text))
        closeSoftKeyboard()
    }

    fun performReplace(@IdRes resId: Int, text: String) {
        onView(withId(resId)).perform(replaceText(text))
        closeSoftKeyboard()
    }

    fun performClearText(@IdRes resId: Int) {
        onView(withId(resId)).perform(clearText())
    }

    fun recyclerItemAction(position: Int, action: ViewAction): ViewAction {
        return RecyclerViewActions.actionOnItemAtPosition<ViewHolder>(
            position,
            action
        )
    }

    fun expandBottmSheet(bottomSheet: View) {
        BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
    }

    fun collapseBottmSheet(bottomSheet: View) {
        BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_COLLAPSED
    }

    fun clickBackButton() {
        pressBack()
    }
}