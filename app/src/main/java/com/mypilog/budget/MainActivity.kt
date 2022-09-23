package com.mypilog.budget

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.windowsizeclass.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.*
import androidx.window.layout.WindowInfoTracker.Companion.getOrCreate
import com.mypilog.budget.ui.screen.AppScaffold
import com.mypilog.budget.ui.theme.BudgetTheme
import com.mypilog.budget.util.DevicePosture
import com.mypilog.budget.util.isBookPosture
import com.mypilog.budget.util.isSeparatingPosture
import com.mypilog.budget.util.isTableTopPosture
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

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



