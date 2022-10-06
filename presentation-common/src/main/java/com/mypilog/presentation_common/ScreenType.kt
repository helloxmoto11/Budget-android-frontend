package com.mypilog.presentation_common

sealed interface ScreenType {
    object PhonePortrait: ScreenType
    object PhoneLandScape: ScreenType
    object Foldable: ScreenType
}