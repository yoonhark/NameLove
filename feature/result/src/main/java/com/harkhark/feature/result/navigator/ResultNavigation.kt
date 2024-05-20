package com.harkhark.feature.result.navigator

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.harkhark.feature.result.ResultScreen


const val RESULT_ROUTE = "result_route"

const val ARGS_SNAME = "sname"
const val ARGS_FNAME = "fname"

fun NavController.navigateToResult(sname: String, fname: String) =
    navigate("$RESULT_ROUTE/$sname/$fname")

fun NavGraphBuilder.resultScreen() {
    composable(
        route = "$RESULT_ROUTE/{$ARGS_SNAME}/{$ARGS_FNAME}",
        arguments = listOf(
            navArgument(ARGS_SNAME) { type = NavType.StringType },
            navArgument(ARGS_FNAME) { type = NavType.StringType },
        ),
    ) {
        ResultScreen(it.arguments?.getString(ARGS_SNAME)!!, it.arguments?.getString(ARGS_FNAME)!!)
    }
}