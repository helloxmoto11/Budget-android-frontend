package com.mypilog.budget.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mypilog.budget.ui.screen.Screen.Home

sealed class Screen(val route: String) {
    object Home : Screen("Home")
}

@Composable
fun NavComponent(
    navController: NavHostController,
    paddingValues: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = Modifier.padding(paddingValues)) {

            composable(Home.route) {
                HomeScreen()
            }

        }

}