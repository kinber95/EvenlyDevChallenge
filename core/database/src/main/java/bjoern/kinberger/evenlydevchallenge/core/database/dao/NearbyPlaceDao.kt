package bjoern.kinberger.evenlydevchallenge.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import bjoern.kinberger.evenlydevchallenge.core.database.model.NearbyPlaceEntity

@Dao
interface NearbyPlaceDao {
    @Query("SELECT * FROM nearby_places")
    suspend fun getNearbyPlaces(): List<NearbyPlaceEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNearbyPlaces(nearbyPlaces: List<NearbyPlaceEntity>)
}