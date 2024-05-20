package com.hakrhark.feature.splash.navigator

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hakrhark.feature.splash.SplashScreen


const val SPLASH_ROUTE = "splash_route"

fun NavController.navigateToSplash(navOptions: NavOptions) = navigate(SPLASH_ROUTE, navOptions)
fun NavGraphBuilder.splashScreen(onSuccess:()->Unit) {
    composable(route = SPLASH_ROUTE) {
        SplashScreen(onSuccess)
    }
}