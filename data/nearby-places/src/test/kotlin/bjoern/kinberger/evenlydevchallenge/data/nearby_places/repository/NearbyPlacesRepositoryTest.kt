package bjoern.kinberger.evenlydevchallenge.data.nearby_places.repository

import android.util.Log
import bjoern.kinberger.evenlydevchallenge.core.database.NearbyPlacesLocalDataSource
import bjoern.kinberger.evenlydevchallenge.core.network.NearbyPlacesRemoteDataSource
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.fake.fakeNearbyPlaceEntity
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.fake.fakeNetworkNearbyPlaces
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.model.toNearbyPlace
import io.mockk.coEvery
import io.mockk.coJustRun
import io.mockk.coVerifyOrder
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test


class NearbyPlacesRepositoryTest {

    private val nearbyPlacesLocalDataSourceMock: NearbyPlacesLocalDataSource = mockk {
        coJustRun { insertNearbyPlaces(any()) }
        coEvery { getNearbyPlaces() } returns listOf(fakeNearbyPlaceEntity)
    }
    private val nearbyPlacesRemoteDataSourceMock: NearbyPlacesRemoteDataSource = mockk {
        coEvery { getNearbyPlaces(any(), any()) } returns fakeNetworkNearbyPlaces
    }

    @Test
    fun `Given remote data, when request foursquare nearby endpoint, then return inserted data`() =
        runTest {
            val repository = FoursquareNearbyPlacesRepository(
                nearbyPlacesRemoteDataSource = nearbyPlacesRemoteDataSourceMock,
                nearbyPlacesLocalDataSource = nearbyPlacesLocalDataSourceMock
            )

            val result = repository.findNearbyPlaces(
                latitude = 23.0000,
                longitude = 13.0000
            )

            coVerifyOrder {
                nearbyPlacesRemoteDataSourceMock.getNearbyPlaces(any(), any())
                nearbyPlacesLocalDataSourceMock.insertNearbyPlaces(any())
                nearbyPlacesLocalDataSourceMock.getNearbyPlaces()
            }

            assertEquals(
                result,
                nearbyPlacesLocalDataSourceMock.getNearbyPlaces().map { it.toNearbyPlace() }
            )
        }

    @Test
    fun `Given no remote data, when request foursquare nearby endpoint, then return local data`() =
        runTest {
            coEvery {
                nearbyPlacesRemoteDataSourceMock.getNearbyPlaces(
                    any(),
                    any()
                )
            } throws Exception("Oops")
            mockkStatic(Log::class)
            every { Log.d(any(), any()) } returns 0
            val repository = FoursquareNearbyPlacesRepository(
                nearbyPlacesRemoteDataSource = nearbyPlacesRemoteDataSourceMock,
                nearbyPlacesLocalDataSource = nearbyPlacesLocalDataSourceMock
            )

            val result = repository.findNearbyPlaces(
                latitude = 23.0000,
                longitude = 13.0000
            )

            coVerifyOrder {
                nearbyPlacesRemoteDataSourceMock.getNearbyPlaces(any(), any())
                nearbyPlacesLocalDataSourceMock.getNearbyPlaces()
            }

            assertEquals(
                result,
                nearbyPlacesLocalDataSourceMock.getNearbyPlaces().map { it.toNearbyPlace() }
            )
        }
}