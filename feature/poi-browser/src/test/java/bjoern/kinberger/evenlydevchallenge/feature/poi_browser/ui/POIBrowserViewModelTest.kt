@file:OptIn(ExperimentalCoroutinesApi::class)

package bjoern.kinberger.evenlydevchallenge.feature.poi_browser.ui

import bjoern.kinberger.evenlydevchallenge.data.nearby_places.repository.NearbyPlacesRepository
import bjoern.kinberger.evenlydevchallenge.feature.poi_browser.POIBrowserUiState
import bjoern.kinberger.evenlydevchallenge.feature.poi_browser.POIBrowserViewModel
import bjoern.kinberger.evenlydevchallenge.feature.poi_browser.fake.fakePointsOfInterests
import io.mockk.coEvery
import io.mockk.mockk
import kotlin.test.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class POIBrowserViewModelTest {

    private val nearbyPlacesRepositoryMock: NearbyPlacesRepository = mockk {
        coEvery { findNearbyPlaces(any(), any()) } returns listOf(fakePointsOfInterests)
    }

    @AfterEach
    fun clean() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Given viewmodel, when start collecting, then return data`() = runTest {
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)

        val viewModel = POIBrowserViewModel(
            nearbyPlacesRepository = nearbyPlacesRepositoryMock,
        )

        assertEquals(
            POIBrowserUiState.Loading,
            viewModel.poiBrowserUiState.value
        )

        backgroundScope.launch(testDispatcher) {
            viewModel.poiBrowserUiState.collect {}
        }

        assertEquals(
            POIBrowserUiState.PointOfInterest(pointsOfInterests = listOf(fakePointsOfInterests)),
            viewModel.poiBrowserUiState.value
        )
    }

}