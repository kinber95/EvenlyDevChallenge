package bjoern.kinberger.evenlydevchallenge.core.database.di

import android.content.Context
import androidx.room.Room
import bjoern.kinberger.evenlydevchallenge.core.database.EvenlyDatabase
import bjoern.kinberger.evenlydevchallenge.core.database.dao.NearbyPlaceDao
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

private const val DATABASE_NAME = "evenly-dev-challenge-database"

@Module
@ComponentScan("bjoern.kinberger.evenlydevchallenge.core.database")
class DatabaseModule {

    @Single
    fun roomDatabase(
        context: Context,
    ) = Room.databaseBuilder(
        context,
        EvenlyDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Factory
    fun nearbyPlaceDao(
        database: EvenlyDatabase
    ): NearbyPlaceDao = database.nearbyPlaceDao()

}