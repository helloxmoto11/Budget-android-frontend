package com.mypilog.budget

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.*
import com.mypilog.budget.ui.screen.AppScaffold
import com.mypilog.budget.ui.theme.BudgetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"

    private lateinit var windowInfoTracker: WindowInfoTracker

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val windowSizeClass = calculateWindowSizeClass(this)
            val width = windowSizeClass.widthSizeClass
            val height = windowSizeClass.heightSizeClass

            Log.d(TAG, "onCreate: height is $height")

            BudgetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    AppScaffold(
                        navController = navController,
                        shouldShowNavRail = width == WindowWidthSizeClass.Medium || width == WindowWidthSizeClass.Expanded,
                        shouldShowAppBar = height == WindowHeightSizeClass.Compact
                    )
                }
            }
        }
    }



}



