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
import androidx.compose.runtime.Composable
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
fun ExpenseItem(

) {
    Card(onClick = { /*TODO*/ }) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Starbucks")
                Spacer(modifier = Modifier.weight(1f, true))
                Text(text = "$4.35")
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun IncomeItem() {
    Card(onClick = { /*TODO*/ }) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Mid Month Pay")
                Spacer(modifier = Modifier.weight(1f, true))
                Text(text = "$3200")
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


@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewExpenseItem() {
    BudgetTheme {
        Surface {
            Column() {
                ExpenseItem()
                Spacer(modifier = Modifier.height(20.dp))
                IncomeItem()
            }

        }
    }
}