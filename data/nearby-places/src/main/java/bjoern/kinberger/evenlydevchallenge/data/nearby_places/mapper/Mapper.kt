package bjoern.kinberger.evenlydevchallenge.data.nearby_places.mapper

import bjoern.kinberger.evenlydevchallenge.core.database.model.NearbyPlaceEntity
import bjoern.kinberger.evenlydevchallenge.core.network.model.Place

fun Place.toNearbyPlaceEntity() = NearbyPlaceEntity(
    id = fsqId,
    name = name,
    categoryName = categories.first().name,
    city = location.locality,
    street = location.address,
    postcode = location.postcode
)