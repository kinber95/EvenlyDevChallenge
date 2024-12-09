package bjoern.kinberger.evenlydevchallenge.data.nearby_places.repository

import arrow.core.Either
import bjoern.kinberger.evenlydevchallenge.core.network.NearbyPlacesRemoteDataSource
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.model.NearbyPlace
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.model.toNearbyPLace
import org.koin.core.annotation.Single

interface NearbyPlacesRepository {
    suspend fun findNearbyPlaces(
        latitude: Double,
        longitude: Double
    ): Either<Error, List<NearbyPlace>>
}

@Single
internal class FoursquareNearbyPlacesRepository(
    private val nearbyPlacesRemoteDataSource: NearbyPlacesRemoteDataSource
) : NearbyPlacesRepository {
    override suspend fun findNearbyPlaces(
        latitude: Double,
        longitude: Double
    ): Either<Error, List<NearbyPlace>> =
        nearbyPlacesRemoteDataSource.getNearbyPlaces(
            longitude = longitude,
            latitude = latitude
        ).map {
            it.places.map { place ->
                place.toNearbyPLace()
            }
        }

}