package com.mypilog.budget.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mypilog.budget.ui.AppNavRail
import kotlinx.coroutines.launch

private const val TAG = "AppScaffold"

@Composable
fun AppScaffold(
    navController: NavHostController,
    shouldShowNavRail: Boolean,
    shouldShowTopAppBar: Boolean
) {

    val scaffoldState = rememberScaffoldState()

    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { if (shouldShowTopAppBar) TopBar() },
        bottomBar = { if (!shouldShowNavRail) BottomBar() },
        floatingActionButton = {
            FabContainer(
                onDismissRequest = {},
                onItemSelected = {
                    navController.navigate("${Screen.Add.route}/$it") {
                        popUpTo(
                            Screen.Home.route
                        )
                        launchSingleTop = true
                    }
                }
            )
        },
        floatingActionButtonPosition = if (shouldShowNavRail) FabPosition.End else FabPosition.Center,
        isFloatingActionButtonDocked = true


    ) { paddingValues ->
        Row(modifier = Modifier.padding(paddingValues)) {
            if (shouldShowNavRail) {
                AppNavRail(
                    navController = navController,
                    items = listOf("Home", "Stats", "Settings", "Search")
                )
            }

            NavComponent(
                navController = navController,
                onError = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(it)
                    }
                },
                scrollableTabRow = !shouldShowNavRail
            )
        }

    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Budget") }
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

@Composable
fun FabContainer(
    onDismissRequest: () -> Unit,
    onItemSelected: (String) -> Unit
) {
    var showMenu by remember {
        mutableStateOf(false)
    }

    val items = listOf("Expense", "Income", "Asset", "Liability")

    Box {
        DropdownMenu(
            expanded = showMenu, onDismissRequest = { showMenu = false },
        ) {
            items.forEachIndexed { _, item ->
                DropdownMenuItem(
                    onClick = {
                        onItemSelected(item)
                        showMenu = false
                    }) {
                    Text(text = "Add $item")
                }
            }
        }
        FloatingActionButton(onClick = { showMenu = true }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Fab Icon")
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 400,
    name = "Phone-Portrait",
    device = Devices.PIXEL_3A
)
@Composable
fun PreviewApp() {
    AppScaffold(
        navController = rememberNavController(),
        shouldShowNavRail = false,
        shouldShowTopAppBar = true
    )
}

@Preview(
    showBackground = true,
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
        shouldShowTopAppBar = false
    )
}

@Preview(
    showBackground = true,
    name = "Fold",
    device = Devices.FOLDABLE,
)
@Composable
fun PreviewFoldApp() {
    AppScaffold(
        navController = rememberNavController(),
        shouldShowNavRail = true,
        shouldShowTopAppBar = true
    )
}