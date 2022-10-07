package com.mypilog.presentation_add.asset

import java.time.LocalDate

data class AddAssetScreenState(
    val asset: String = "",
    val type: String = "",
    val value: Double = 0.0,
    val date: String = LocalDate.now().toString()
)