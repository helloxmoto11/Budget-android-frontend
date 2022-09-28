package com.mypilog.budget.ui.screen.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mypilog.budget.ui.theme.BudgetTheme

@Composable
fun PieChart(
    tempText: String,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.LightGray, RoundedCornerShape(10.dp))
    ) {
        Text(text = "$tempText Chart Goes Here")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BudgetItem(
    name: String = "Starbucks",
    amount: String = "$3.98"
) {
    Card(onClick = { /*TODO*/ }) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = name)
                Spacer(modifier = Modifier.weight(1f, true))
                Text(text = amount)
                Spacer(modifier = Modifier.weight(1f, true))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete")
                }
            }

        }
    }
}

@Composable
fun AppTabRow(
    scrollable: Boolean,
    selected: BudgetType,
    onSelectedChange: (BudgetType) -> Unit
) {

    val titles = listOf(
        BudgetType.Expenses,
        BudgetType.Income,
        BudgetType.Assets,
        BudgetType.Liabilities
    )

    val tabRowIndex = titles.indexOf(selected)

    if (scrollable) {
        ScrollableTabRow(selectedTabIndex = tabRowIndex) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(text = title.name) },
                    selected = selected == title,
                    onClick = {
                        onSelectedChange(titles[index])
                    })
            }
        }
    } else {
        TabRow(selectedTabIndex = tabRowIndex) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(text = title.name) },
                    selected = selected == title,
                    onClick = {
                        onSelectedChange(titles[index])
                    })
            }
        }
    }
}


@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewExpenseItem() {
    BudgetTheme {
        Surface {
            Column {
                BudgetItem("Starbucks", "$3.95")
                Spacer(modifier = Modifier.height(20.dp))
                BudgetItem(name = "End Month Pay", amount = "$15,000")
                Spacer(modifier = Modifier.height(20.dp))
                BudgetItem(name = "VTSAX", amount = "$64,543")
                Spacer(modifier = Modifier.height(20.dp))
                BudgetItem(name = "Car Note", amount = "$4,100")
            }

        }
    }
}