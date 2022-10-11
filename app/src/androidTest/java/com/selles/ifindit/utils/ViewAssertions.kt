package com.selles.ifindit.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.selles.ifindit.R
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf

object ViewAssertions {

    fun checkUpSideDown(position: Int, text: String) {
        assertAtSongList(
            position,
            allOf(
                withId(R.id.trackNameTextView),
                withText(text)
            )
        )
    }

    private fun assertAtSongList(position: Int, matcher: Matcher<View>) {
        checkRecyclerViewItem(R.id.findItRecyclerView, position, matcher)
    }

    private fun checkRecyclerViewItem(resId: Int, position: Int, withMatcher: Matcher<View>) {
        onView(withId(resId))
            .perform(
                RecyclerViewActions.scrollToPosition<ViewHolder>(
                    position
                )
            )
            .check(matches(withMatcher))
    }
}