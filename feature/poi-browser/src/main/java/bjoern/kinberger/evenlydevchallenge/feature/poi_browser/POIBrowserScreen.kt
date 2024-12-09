package bjoern.kinberger.evenlydevchallenge.feature.poi_browser

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.model.NearbyPlace
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun POIBrowserScreen(
    modifier: Modifier = Modifier,
    viewModel: POIBrowserViewModel = koinViewModel()
) {
    val uiState by viewModel.poiBrowserUiState.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier,
    ) {

        when (uiState) {
            POIBrowserUiState.Error -> item {
                Text("Something went wrong!")
            }

            POIBrowserUiState.Loading -> item {
                Text("POI's are loading...")
            }

            is POIBrowserUiState.PointOfInterest -> {
                (uiState as POIBrowserUiState.PointOfInterest).pointsOfInterests.forEach { poi ->
                    item {
                        POICell(poi = poi)
                    }
                }
            }
        }
    }
}

@Composable
private fun POICell(
    poi: NearbyPlace
) {
    var showLocationDetails by rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                showLocationDetails = !showLocationDetails
            },
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(poi.name)
            Text(poi.categoryName)

            if (showLocationDetails) {
                Text("${poi.location.street}, ${poi.location.city} ${poi.location.postcode}")
            }
        }

    }
}