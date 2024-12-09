package bjoern.kinberger.evenlydevchallenge.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "nearby_places"
)
data class NearbyPlaceEntity(
    @PrimaryKey val id: String,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("category_name") val categoryName: String,
    @ColumnInfo("street") val street: String,
    @ColumnInfo("city") val city: String,
    @ColumnInfo("postcode") val postcode: String,
)