package bjoern.kinberger.evenlydevchallenge.feature.poi_browser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.model.NearbyPlace
import bjoern.kinberger.evenlydevchallenge.data.nearby_places.repository.NearbyPlacesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import org.koin.android.annotation.KoinViewModel


internal sealed interface POIBrowserUiState {
    data class PointOfInterest(
        val pointsOfInterests: List<NearbyPlace>
    ) : POIBrowserUiState

    data object Loading : POIBrowserUiState

    data object Error : POIBrowserUiState
}

@KoinViewModel
internal class POIBrowserViewModel(
    private val nearbyPlacesRepository: NearbyPlacesRepository
) : ViewModel() {

    private val _poiBrowserUiState = MutableStateFlow<POIBrowserUiState>(POIBrowserUiState.Loading)
    val poiBrowserUiState: StateFlow<POIBrowserUiState> = _poiBrowserUiState
        .onStart {
            val nearbyPlaces = nearbyPlacesRepository.findNearbyPlaces(
                latitude = 52.500342,
                longitude = 13.425170
            )
            _poiBrowserUiState.update { _ ->
                if (nearbyPlaces.isEmpty()) {
                    POIBrowserUiState.Error
                } else {
                    POIBrowserUiState.PointOfInterest(nearbyPlaces)
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = POIBrowserUiState.Loading
        )
}