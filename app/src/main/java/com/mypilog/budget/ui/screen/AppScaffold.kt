package com.mypilog.budget.ui.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mypilog.budget.ui.AppNavRail

@Composable
fun AppScaffold(
    navController: NavHostController,
    shouldShowNavRail: Boolean,
    shouldShowAppBar: Boolean
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { if (!shouldShowAppBar) TopBar() },
        bottomBar = { if (!shouldShowNavRail) BottomBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Fab Icon")
            }
        },
        floatingActionButtonPosition = if (shouldShowNavRail) FabPosition.End else FabPosition.Center,
        isFloatingActionButtonDocked = true


    ) { paddingValues ->
        Row(modifier = Modifier.padding(paddingValues)) {
            if (shouldShowNavRail) {
                AppNavRail(
                    navController = navController,
                    items = listOf("Home", "Settings", "Stats", "More", "Search")
                )
            }

            NavComponent(navController = navController)
        }

    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Title") }
    )
}

@Composable
fun BottomBar(

) {
    BottomAppBar(

    ) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Icon")
            }
        }
        Spacer(modifier = Modifier.weight(1f, true))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    widthDp = 400,
    name = "Phone-Portrait",
    device = Devices.PIXEL_3A
)
@Composable
fun PreviewApp() {
    AppScaffold(
        navController = rememberNavController(),
        shouldShowNavRail = false,
        shouldShowAppBar = true
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    widthDp = 1080,
    heightDp = 360,
    name = "Phone-landscape",
    device = Devices.AUTOMOTIVE_1024p
)
@Composable
fun PreviewAppHorizontal() {
    AppScaffold(
        navController = rememberNavController(),
        shouldShowNavRail = true,
        shouldShowAppBar = false
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Fold",
    device = Devices.FOLDABLE,
)
@Composable
fun PreviewFoldApp() {
    AppScaffold(
        navController = rememberNavController(),
        shouldShowNavRail = true,
        shouldShowAppBar = true
    )
}