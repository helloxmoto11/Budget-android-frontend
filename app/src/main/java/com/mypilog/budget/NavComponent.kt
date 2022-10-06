package com.mypilog.budget

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mypilog.budget.Screen.Home
import com.mypilog.presentation_common.BudgetType
import com.mypilog.presentation_common.ScreenType

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
                com.mypilog.presentation_home.HomeScreen(
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
                com.mypilog.presentation_add.AddScreen(
                    type = BudgetType.Expenses,
                    screenType = screenType
                )
            }

        }

}