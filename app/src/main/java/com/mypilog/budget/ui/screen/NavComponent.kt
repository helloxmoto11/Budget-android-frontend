package com.mypilog.budget.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mypilog.budget.ScreenType
import com.mypilog.budget.ui.screen.Screen.Home
import com.mypilog.budget.ui.screen.Screen.Home.route
import com.mypilog.budget.ui.screen.add.AddScreen
import com.mypilog.budget.ui.screen.home.BudgetType
import com.mypilog.budget.ui.screen.home.HomeScreen

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Add : Screen("Add")
}

@Composable
fun NavComponent(
    navController: NavHostController,
    onError: (String) -> Unit,
    scrollableTabRow: Boolean,
    screenType: ScreenType
) {

    NavHost(
        navController = navController,
        startDestination = Home.route) {

            composable(Home.route) {
                HomeScreen(
                    onError = onError,
                    scrollableTabRow = scrollableTabRow
                )
            }

            composable("${Screen.Add.route}/{screen}") { backStackEntry ->
                val type = when (backStackEntry.arguments?.getString("screen")) {
                    "Expense" -> BudgetType.Expenses
                    "Income" -> BudgetType.Income
                    "Asset" -> BudgetType.Assets
                    "Liability" -> BudgetType.Liabilities
                    else -> BudgetType.Expenses
                }
                AddScreen(type = BudgetType.Expenses, screenType = screenType)
            }

        }

}