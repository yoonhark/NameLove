package com.harkhark.namelove.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.hakrhark.feature.splash.navigator.SPLASH_ROUTE
import com.harkhark.feature.input.navigation.inputScreen
import com.harkhark.feature.input.navigation.navigateToInput
import com.harkhark.feature.result.navigator.resultScreen
import com.hakrhark.feature.splash.navigator.splashScreen
import com.harkhark.feature.result.navigator.navigateToResult

@Composable
fun AppNavHost(

){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SPLASH_ROUTE
    ) {
        splashScreen(onSuccess = navController::navigateToInput)
        inputScreen(onCalcClick = navController::navigateToResult)
        resultScreen()
    }
}