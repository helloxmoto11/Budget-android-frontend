package com.mypilog.budget

sealed interface ScreenType {
    object PhonePortrait: ScreenType
    object PhoneLandScape: ScreenType
    object Foldable: ScreenType
}