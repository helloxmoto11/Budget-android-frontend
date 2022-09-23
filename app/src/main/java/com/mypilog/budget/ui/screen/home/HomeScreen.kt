package com.mypilog.budget.ui.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mypilog.budget.ui.theme.BudgetTheme

@Composable
fun HomeScreen() {

    HomeScreenUi()
}

@Composable
fun HomeScreenUi() {
    var state by remember {
        mutableStateOf(0)
    }
    val titles = listOf("Expenses", "Income", "Assets", "Liabilities")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {


        ScrollableTabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(text = title)},
                    selected = state == index,
                    onClick = { state = index })
            }
        }


        PieChart(
            tempText = titles[state],
            modifier = Modifier
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PreviewHomeScreenUi() {
    BudgetTheme {
        Surface {
            HomeScreenUi()
        }
    }
}