package bjoern.kinberger.evenlydevchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import bjoern.kinberger.evenlydevchallenge.core.navigation.POIBrowser
import bjoern.kinberger.evenlydevchallenge.feature.poi_browser.navigation.poiBrowserScreen

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = POIBrowser,
        modifier = modifier
    ) {
        poiBrowserScreen()
    }
}