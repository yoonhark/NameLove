package com.harkhark.feature.input.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.harkhark.feature.input.InputScreen


const val INPUT_ROUTE = "input_route"

fun NavController.navigateToInput() = navigate(INPUT_ROUTE)
fun NavGraphBuilder.inputScreen(
    onCalcClick: (String,String) -> Unit,
) {
    composable(route = INPUT_ROUTE) {
        InputScreen(onCalcClick)
    }
}