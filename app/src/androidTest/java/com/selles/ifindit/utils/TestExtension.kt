package com.selles.ifindit.utils

import android.view.View
import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.selles.ifindit.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf

fun checkButtonDisplayed(@StringRes resId: Int) {
    onView(withId(resId))
        .check(matches(ViewMatchers.isDisplayed()))
}

fun checkBottomSheetState(expectedState: Int) {
//    onView(allOf(withId(R.id.bottom_sheet_layout)))
    onView(allOf(withId(R.id.bottom_sheet_layout)))
//    onView(allOf(withId(R.id.bottom_sheet_layout)))
        .check(matches(hasBottomSheetBehaviorState(expectedState)))
}

fun hasBottomSheetBehaviorState(expectedState: Int): Matcher<in View> {
    return object : BoundedMatcher<View, View>(View::class.java) {
        override fun describeTo(description: Description) {
            description.appendText("has BottomSheetBehavior state $expectedState")
        }

        override fun matchesSafely(view: View): Boolean {
            val bottomSheetBehavior = BottomSheetBehavior.from(view)
            return expectedState == bottomSheetBehavior.state
        }
    }
}

fun withParent(parentMatcher: Matcher<View>, hierarchyLevel: Int): Matcher<View?> {
    return WithParentMatcher(parentMatcher, hierarchyLevel)
}

fun <T> MutableLiveData<T>.setValueOnMainThread(value: T) {
    InstrumentationRegistry.getInstrumentation().runOnMainSync {
        this.value = value
    }
}