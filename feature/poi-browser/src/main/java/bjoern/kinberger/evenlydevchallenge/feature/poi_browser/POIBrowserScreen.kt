package bjoern.kinberger.evenlydevchallenge.feature.poi_browser

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White,
            disabledContentColor = Color.White,
            disabledContainerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)

            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = poi.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = poi.categoryName,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "${poi.location.street}, ${poi.location.city} ${poi.location.postcode}",
                    style = MaterialTheme.typography.bodyMedium
                )

            }
        }


    }
}