package bjoern.kinberger.evenlydevchallenge.data.nearby_places.fake

import bjoern.kinberger.evenlydevchallenge.core.database.model.NearbyPlaceEntity
import bjoern.kinberger.evenlydevchallenge.core.network.model.Category
import bjoern.kinberger.evenlydevchallenge.core.network.model.Coordinate
import bjoern.kinberger.evenlydevchallenge.core.network.model.Geocodes
import bjoern.kinberger.evenlydevchallenge.core.network.model.Icon
import bjoern.kinberger.evenlydevchallenge.core.network.model.Location
import bjoern.kinberger.evenlydevchallenge.core.network.model.NetworkNearbyPlaces
import bjoern.kinberger.evenlydevchallenge.core.network.model.Place

val fakeNearbyPlaceEntity = NearbyPlaceEntity(
    id = "id",
    name = "name",
    categoryName = "category_name",
    street = "street",
    city = "city",
    postcode = "postcode"

)

val fakeNetworkNearbyPlaces = NetworkNearbyPlaces(
    places = listOf(
        Place(
            fsqId = "fsqId",
            categories = listOf(
                Category(
                    id = 1,
                    name = "name",
                    shortName = "shortName",
                    pluralName = "pluralName",
                    icon = Icon(
                        prefix = "prefix",
                        suffix = "suffix"
                    )
                ),
                Category(
                    id = 2,
                    name = "name",
                    shortName = "shortName",
                    pluralName = "pluralName",
                    icon = Icon(
                        prefix = "prefix",
                        suffix = "suffix"
                    )
                )
            ),
            closedBucket = null,
            distance = 0,
            geocodes = Geocodes(
                dropOff = null,
                main = Coordinate(latitude = 40.7128, longitude = -74.0060),
                roof = Coordinate(latitude = 40.7138, longitude = -74.0050)
            ),
            link = "link",
            location = Location(
                address = "address",
                country = "country",
                crossStreet = "crossStreet",
                formattedAddress = "formattedAddress",
                locality = "locality",
                postcode = "postcode",
                region = "region"
            ),
            name = "name",
            timezone = "timezone"
        )
    )
)