package bjoern.kinberger.evenlydevchallenge.feature.poi_browser.fake

import bjoern.kinberger.evenlydevchallenge.data.nearby_places.model.NearbyPlace

val fakePointsOfInterests = NearbyPlace(
    name = "name",
    categoryName = "category_name",
    location = NearbyPlace.Location(
        street = "street",
        city = "city",
        postcode = "postcode"
    )
)