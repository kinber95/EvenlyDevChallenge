package bjoern.kinberger.evenlydevchallenge.feature.poi_browser.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import bjoern.kinberger.evenlydevchallenge.core.navigation.POIBrowser
import bjoern.kinberger.evenlydevchallenge.feature.poi_browser.POIBrowserScreen

fun NavGraphBuilder.poiBrowserScreen(modifier: Modifier = Modifier) {
    composable<POIBrowser> {
        POIBrowserScreen(modifier = modifier)
    }
}