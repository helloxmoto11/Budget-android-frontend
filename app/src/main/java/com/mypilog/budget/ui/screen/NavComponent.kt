package com.mypilog.budget.ui.screen

import androidx.compose.runtime.Composable
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
) {

    NavHost(
        navController = navController,
        startDestination = Home.route) {

            composable(Home.route) {
                HomeScreen()
            }

        }

}