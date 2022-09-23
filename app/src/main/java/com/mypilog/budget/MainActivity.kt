package com.mypilog.budget

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.DisplayFeature
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import androidx.window.layout.WindowInfoTracker.Companion.getOrCreate
import androidx.window.layout.WindowMetricsCalculator
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val devicePosture = getOrCreate(this).windowLayoutInfo(this)
            .flowWithLifecycle(this.lifecycle)
            .map { layoutInfo ->
                val foldingFeature =
                    layoutInfo.displayFeatures.filterIsInstance<FoldingFeature>().firstOrNull()

                Log.d(TAG, "onCreate: Features are ${layoutInfo.displayFeatures}")
                Log.d(TAG, "onCreate: orientation = ${foldingFeature?.orientation}")
                when {
                    isTableTopPosture(foldingFeature) ->
                        DevicePosture.TableTopPosture(foldingFeature.bounds)
                    isBookPosture(foldingFeature) ->
                        DevicePosture.BookPosture(foldingFeature.bounds)
                    isSeparatingPosture(foldingFeature) ->
                        DevicePosture.SeparatingPosture(foldingFeature.bounds, foldingFeature.orientation)
                    else -> DevicePosture.NormalPosture
                }
            }
            .stateIn(
                scope = lifecycleScope,
                started = SharingStarted.Eagerly,
                initialValue = DevicePosture.NormalPosture
            )

        setContent {
            BudgetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    AppScaffold(navController = navController)
                }
            }
        }
    }



}



