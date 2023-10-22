package com.npace.kmpdemo

import app.cash.turbine.TurbineTestContext
import app.cash.turbine.test
import com.npace.kmpdemo.MainViewModel.MainUIState
import com.npace.kmpdemo.api.CheeseResponse
import com.npace.kmpdemo.apiclient.ApiClient
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
    private val api = object: ApiClient {
        var response = emptyList<CheeseResponse>()
        override suspend fun loadItems(): List<CheeseResponse> = response
    }

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
    fun `loads items from API and maps them to UI state`() = testState {
        api.response = listOf(CheeseResponse("foo"))
        val expectedState = MainUIState(
            false,
            listOf(CheeseViewState("foo")),
        )

        dispatcher.scheduler.advanceUntilIdle()
        val latestState = this.expectMostRecentItem()

        assertEquals(expectedState, latestState)
    }

    private fun testState(validate: suspend TurbineTestContext<MainUIState>.() -> Unit) {
        return runBlocking {
            MainViewModel(api).state.test(validate = validate)
        }
    }
}
