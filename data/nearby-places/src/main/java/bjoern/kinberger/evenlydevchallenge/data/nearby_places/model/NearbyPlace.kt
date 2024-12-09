package bjoern.kinberger.evenlydevchallenge.data.nearby_places.model

import bjoern.kinberger.evenlydevchallenge.core.database.model.NearbyPlaceEntity
import bjoern.kinberger.evenlydevchallenge.core.network.model.Place

data class NearbyPlace(
    val name: String,
    val categoryName: String,
    val location: Location
) {
    data class Location(
        val street: String,
        val city: String,
        val postcode: String,
    )
}

fun Place.toNearbyPLace() = NearbyPlace(
    name = name,
    categoryName = categories.first().name,
    location = NearbyPlace.Location(
        street = location.address,
        city = location.locality,
        postcode = location.postcode
    )
)

fun NearbyPlaceEntity.toNearbyPlace() = NearbyPlace(
    name = name,
    categoryName = categoryName,
    location = NearbyPlace.Location(
        street = street,
        city = city,
        postcode = postcode,
    )
)
