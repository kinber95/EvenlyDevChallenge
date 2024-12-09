package bjoern.kinberger.evenlydevchallenge.core.network

import arrow.core.Either
import bjoern.kinberger.evenlydevchallenge.core.network.model.NetworkNearbyPlaces
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Single

private const val BASE_URL = "https://api.foursquare.com/v3/places/nearby"

@Single
internal class KtorNearbyPlacesRemoteDataSource(
    private val foursquareApiClient: HttpClient,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : NearbyPlacesRemoteDataSource {
    override suspend fun getNearbyPlaces(
        latitude: Double,
        longitude: Double
    ): Either<Error, NetworkNearbyPlaces> =
        withContext(ioDispatcher) {
            try {
                val resultBody: NetworkNearbyPlaces =
                    foursquareApiClient.get("$BASE_URL?ll=$latitude%2C$longitude").body()
                Either.Right(resultBody)
            } catch (e: Exception) {
                Either.Left(Error("Something went wrong", e))
            }
        }

}
