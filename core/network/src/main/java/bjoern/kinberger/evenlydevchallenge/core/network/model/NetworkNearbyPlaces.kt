package bjoern.kinberger.evenlydevchallenge.core.network.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class NetworkNearbyPlaces(
    @SerialName("results") val places: List<Place>
)

@Serializable
data class Place(
    @SerialName("fsq_id") val fsqId: String,
    @SerialName("categories") val categories: List<Category>,
    @SerialName("closed_bucket") val closedBucket: String?,
    @SerialName("distance") val distance: Int,
    @SerialName("geocodes") val geocodes: Geocodes,
    @SerialName("link") val link: String,
    @SerialName("location") val location: Location,
    @SerialName("name") val name: String,
    @SerialName("timezone") val timezone: String
)

@Serializable
data class Category(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("short_name") val shortName: String,
    @SerialName("plural_name") val pluralName: String,
    @SerialName("icon") val icon: Icon
)

@Serializable
data class Icon(
    @SerialName("prefix") val prefix: String,
    @SerialName("suffix") val suffix: String
)


@Serializable
data class Geocodes(
    @SerialName("drop_off") val dropOff: Coordinate? = null,
    @SerialName("main") val main: Coordinate,
    @SerialName("roof") val roof: Coordinate?
)

@Serializable
data class Coordinate(
    @SerialName("latitude") val latitude: Double,
    @SerialName("longitude") val longitude: Double
)

@Serializable
data class Location(
    @SerialName("address") val address: String,
    @SerialName("country") val country: String,
    @SerialName("cross_street") val crossStreet: String? = null,
    @SerialName("formatted_address") val formattedAddress: String,
    @SerialName("locality") val locality: String,
    @SerialName("postcode") val postcode: String,
    @SerialName("region") val region: String
)
