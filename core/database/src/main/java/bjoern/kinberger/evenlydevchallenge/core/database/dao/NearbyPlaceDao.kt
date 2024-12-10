package bjoern.kinberger.evenlydevchallenge.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import bjoern.kinberger.evenlydevchallenge.core.database.model.NearbyPlaceEntity

@Dao
interface NearbyPlaceDao {
    @Query("SELECT * FROM nearby_places")
    suspend fun getNearbyPlaces(): List<NearbyPlaceEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNearbyPlaces(nearbyPlaces: List<NearbyPlaceEntity>)

    @Query("DELETE from nearby_places")
    suspend fun clearTable()

    @Transaction
    suspend fun insertNearbyPlacesAndDeleteOld(nearbyPlaceEntity: List<NearbyPlaceEntity>) {
        clearTable()
        insertNearbyPlaces(nearbyPlaceEntity)
    }
}