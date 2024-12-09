package bjoern.kinberger.evenlydevchallenge.data.nearby_places.repository

import android.util.Log
import bjoern.kinberger.evenlydevchallenge.core.database.NearbyPlacesLocalDataSource
import bjoern.kinberger.evenlydevchallenge.core.network.NearbyPlacesRemoteDataSource
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.mapper.toNearbyPlaceEntity
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.model.NearbyPlace
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.model.toNearbyPlace
import org.koin.core.annotation.Single

interface NearbyPlacesRepository {
    suspend fun findNearbyPlaces(
        latitude: Double,
        longitude: Double
    ): List<NearbyPlace>
}

@Single
internal class FoursquareNearbyPlacesRepository(
    private val nearbyPlacesRemoteDataSource: NearbyPlacesRemoteDataSource,
    private val nearbyPlacesLocalDataSource: NearbyPlacesLocalDataSource,
) : NearbyPlacesRepository {
    override suspend fun findNearbyPlaces(
        latitude: Double,
        longitude: Double
    ): List<NearbyPlace> {
        try {
            val nearbyPlaces = nearbyPlacesRemoteDataSource.getNearbyPlaces(
                longitude = longitude,
                latitude = latitude
            )
            nearbyPlacesLocalDataSource.insertNearbyPlaces(nearbyPlaces.places.map {
                it.toNearbyPlaceEntity()
            })
        } catch (e: Exception) {
            Log.d(
                FoursquareNearbyPlacesRepository::class.java.simpleName,
                "Something went wrong, so use local data!"
            )
        }

        return nearbyPlacesLocalDataSource.getNearbyPlaces().map { it.toNearbyPlace() }
    }

}