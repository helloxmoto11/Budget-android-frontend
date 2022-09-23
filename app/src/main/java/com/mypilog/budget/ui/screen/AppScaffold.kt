package com.mypilog.budget.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun AppScaffold(
    navController: NavHostController
) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Fab Icon")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true


    ) { paddingValues ->
        NavComponent(navController = navController, paddingValues = paddingValues)

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