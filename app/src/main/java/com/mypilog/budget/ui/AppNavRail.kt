package com.mypilog.budget.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun AppNavRail(
    navController: NavHostController,
    backgroundColor: Color = MaterialTheme.colors.surface,
    items: List<String>
) {
    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.Settings,
        Icons.Filled.StackedLineChart,
        Icons.Filled.Search
    )
    NavigationRail() {
        LazyColumn {
            itemsIndexed(items) { i, item ->
                val currentDestination = navController.currentBackStackEntryAsState().value

                NavigationRailItem(
                    icon = { Icon(imageVector = icons[i], contentDescription = item) },
                    label = { Text(text = item) },
                    selected = currentDestination?.destination?.route.let { it == item },
                    onClick = { /*TODO*/ }
                )
            }
        }
    }
}