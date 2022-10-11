package com.selles.ifindit.utils

import androidx.annotation.StringRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText

fun checkTextDisplayed(text: String) {
    onView(withText(text)).check(matches(isDisplayed()))
}

fun checkTextDisplayed(@StringRes textResId: Int) {
    onView(withText(textResId)).check(matches(isDisplayed()))
}