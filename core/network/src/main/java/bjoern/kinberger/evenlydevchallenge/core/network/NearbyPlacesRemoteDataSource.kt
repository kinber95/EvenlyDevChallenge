package bjoern.kinberger.evenlydevchallenge.core.network

import arrow.core.Either
import bjoern.kinberger.evenlydevchallenge.core.network.model.NetworkNearbyPlaces

interface NearbyPlacesRemoteDataSource {
    suspend fun getNearbyPlaces(latitude: Double, longitude: Double): Either<Error, NetworkNearbyPlaces>
}