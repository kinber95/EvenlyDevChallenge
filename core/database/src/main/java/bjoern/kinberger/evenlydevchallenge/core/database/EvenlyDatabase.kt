package bjoern.kinberger.evenlydevchallenge.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import bjoern.kinberger.evenlydevchallenge.core.database.dao.NearbyPlaceDao
import bjoern.kinberger.evenlydevchallenge.core.database.model.NearbyPlaceEntity

@Database(entities = [NearbyPlaceEntity::class], version = 1)
abstract class EvenlyDatabase : RoomDatabase() {
    abstract fun nearbyPlaceDao(): NearbyPlaceDao
}