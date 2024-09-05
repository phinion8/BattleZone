package com.priyanshu.battlezone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val white = Color(0xFFFFFFFF)
val black = Color(0xFF000000)
val blue = Color(0xFF5E76FF)
val green = Color(0xFF01B752)
val cream = Color(0xFFFFC39B)
val gray = Color(0xFF909090)
val darkGreen = Color(0xFF001208)
val darkBlue = Color(0xFF0c0f14)
val mildGreen = Color(0xFF4D5A53)
val softGreen = Color(0xFF182920)
val orange = Color(0xFFFF9800)


val primaryColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) white else black

val secondaryColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) darkBlue else white

val bottomBarBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) black else white

