package bjoern.kinberger.evenlydevchallenge.core.database

import bjoern.kinberger.evenlydevchallenge.core.database.dao.NearbyPlaceDao
import bjoern.kinberger.evenlydevchallenge.core.database.model.NearbyPlaceEntity
import org.koin.core.annotation.Single

@Single
class RoomNearbyPlacesLocalDataSource(
    private val nearbyPlaceDao: NearbyPlaceDao
) : NearbyPlacesLocalDataSource {
    override suspend fun getNearbyPlaces(): List<NearbyPlaceEntity> =
        nearbyPlaceDao.getNearbyPlaces()

    override suspend fun insertNearbyPlaces(nearbyPlaces: List<NearbyPlaceEntity>) =
        nearbyPlaceDao.insertNearbyPlacesAndDeleteOld(nearbyPlaceEntity = nearbyPlaces)
}