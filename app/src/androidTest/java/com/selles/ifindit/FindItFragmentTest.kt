package com.selles.ifindit

import android.os.SystemClock
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.selles.ifindit.domain.usecase.GetITunesSearchUseCase
import com.selles.ifindit.presentation.viewmodel.FindItViewModel
import com.selles.ifindit.presentation.viewmodel.action.FindItAction
import com.selles.ifindit.presentation.viewmodel.state.FindItState
import com.selles.ifindit.utils.*
import com.selles.ifindit.utils.ViewActions.performClick
import com.selles.ifindit.utils.ViewActions.performType
import com.selles.ifindit.utils.ViewActions.recyclerItemAction
import com.selles.ifindit.utils.ViewAssertions.checkUpSideDown
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import org.mockito.kotlin.times
import org.mockito.kotlin.verify


//@RunWith(
//    AndroidJUnit4::class
//)
class FindItFragmentTest {

    //    private val getITunesSearchUseCase: GetITunesSearchUseCase = mockk()
    private lateinit var viewModel: FindItViewModel
    private val fakeState = TestLiveData<FindItState>()
    private val fakeAction = TestLiveData<FindItAction>()

    @get:Rule
    public var activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
//        setupKoinModiles()
    }

    @Test
    fun whenLoadFragment_checkInitialState() {
        checkTextDisplayed(R.string.no_result)
        Espresso.onView(ViewMatchers.withId(R.id.findItRecyclerView))
            .check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.isDisplayed())))
        checkBottomSheetState(BottomSheetBehavior.STATE_COLLAPSED)
    }

    @Test
    fun whenClickOnnewSearch_ShouldOpenBottomSheet() {
        performClick(R.id.newSearchButton)
        SystemClock.sleep(1000)
        checkBottomSheetState(BottomSheetBehavior.STATE_EXPANDED)
    }

    @Test
    fun whenClickOnButton_OpenBottomSheet() {
        performClick(R.id.newSearchButton)
        SystemClock.sleep(1000)
        checkBottomSheetState(BottomSheetBehavior.STATE_EXPANDED)
    }

    @Test
    fun whenSuccessState_ShowData() {
        whenClickOnnewSearch_ShouldOpenBottomSheet()
        performType(R.id.labelTextView, "Johnson")
        performClick(R.id.searchButton)
        SystemClock.sleep(2000)
//        checkUpSideDown(1, "Upside Down")
        checkTextDisplayed("Upside Down")
    }

    @Test
    fun whenClickOnItemNavigateToDetail() {
        whenSuccessState_ShowData()
        recyclerItemAction(position = 1, click())
        SystemClock.sleep(2000)
        checkTextDisplayed("Upside Down")
        SystemClock.sleep(2000)
    }

    private fun setupKoinModiles() {
        viewModel = stubFindItViewModel()
        loadKoinModules(
            module(override = true) {
                viewModel {
                    viewModel
                }
            }
        )
    }

    private fun stubFindItViewModel(): FindItViewModel {
        return mockk(relaxed = true) {
            every { state } returns fakeState
            every { action } returns fakeAction
        }
    }

    fun buildSuccessState() {
        val state = FindItState(
            isLoading = false,
            haveNoData = false,
            searchResult = listOf(FindItHelperUITest.result),
            quantity = 1
        )

        fakeState.setValueOnMainThread(state)
    }

}