package bjoern.kinberger.evenlydevchallenge.core.database

import bjoern.kinberger.evenlydevchallenge.core.database.model.NearbyPlaceEntity

interface NearbyPlacesLocalDataSource {
    suspend fun getNearbyPlaces(): List<NearbyPlaceEntity>
    suspend fun insertNearbyPlaces(nearbyPlaces: List<NearbyPlaceEntity>)
}