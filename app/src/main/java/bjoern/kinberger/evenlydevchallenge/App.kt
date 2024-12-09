package bjoern.kinberger.evenlydevchallenge

import android.app.Application
import bjoern.kinberger.evenlydevchallenge.core.network.di.NetworkModule
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.di.NearbyPlacesDataModule
import bjoern.kinberger.evenlydevchallenge.feature.poi_browser.di.POIBrowserModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    NetworkModule().module,
                    NearbyPlacesDataModule().module,
                    POIBrowserModule().module
                )
            )
        }
    }
}