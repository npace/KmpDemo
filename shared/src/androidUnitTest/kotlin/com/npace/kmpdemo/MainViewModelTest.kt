package com.npace.kmpdemo

import app.cash.turbine.TurbineTestContext
import app.cash.turbine.test
import com.npace.kmpdemo.MainViewModel.MainUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {
    private val dispatcher: TestDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `starts with loading state and empty list`() = testState {
        val expectedState = MainUIState(
            true,
            emptyList()
        )

        val initialState = awaitItem()

        assertEquals(expectedState, initialState)
    }

    @Test
    fun `loads items after delay`() = testState {
        val expectedState = MainUIState(
            false,
            CheeseViewStateFakeData.cheeseViewStates,
        )

        dispatcher.scheduler.advanceUntilIdle()
        val latestState = this.expectMostRecentItem()

        assertEquals(expectedState, latestState)
    }

    private fun testState(validate: suspend TurbineTestContext<MainUIState>.() -> Unit) {
        return runBlocking {
            MainViewModel().state.test(validate = validate)
        }
    }
}
