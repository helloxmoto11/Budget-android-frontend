package com.mypilog.budget.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mypilog.budget.ScreenType
import com.mypilog.budget.ui.AppNavRail
import kotlinx.coroutines.launch

private const val TAG = "AppScaffold"

@Composable
fun AppScaffold(
    navController: NavHostController,
    screenType: ScreenType = ScreenType.PhonePortrait
) {

    val scaffoldState = rememberScaffoldState()

    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            if (screenType is ScreenType.PhonePortrait ||
                screenType is ScreenType.Foldable
            ) TopBar()
        },
        bottomBar = { if (screenType is ScreenType.PhonePortrait) BottomBar() },
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
        floatingActionButtonPosition = if (screenType is ScreenType.PhonePortrait) {
            FabPosition.Center
        } else FabPosition.End,
        isFloatingActionButtonDocked = true


    ) { paddingValues ->
        Row(modifier = Modifier.padding(paddingValues)) {
            if (screenType is ScreenType.Foldable ||
                screenType is ScreenType.PhoneLandScape
            ) {
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
                scrollableTabRow = screenType == ScreenType.PhoneLandScape,
                screenType = screenType
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
    BottomAppBar {
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
        screenType = ScreenType.PhoneLandScape
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
        screenType = ScreenType.Foldable
    )
}