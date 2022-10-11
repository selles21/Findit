package com.selles.ifindit.utils

import android.view.View
import android.view.ViewParent
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher


class WithParentMatcher constructor(
    private val parentMatcher: Matcher<View>,
    private val hierarchyLevel: Int
) : TypeSafeMatcher<View?>() {

    override fun describeTo(description: Description) {
        description.appendText("has parent matching: ")
        parentMatcher.describeTo(description)
    }

    override fun matchesSafely(view: View?): Boolean {
        var viewParent: ViewParent? = view?.parent
        for (index in 1 until hierarchyLevel) {
            viewParent = viewParent?.parent
        }
        return parentMatcher.matches(viewParent)
    }
}