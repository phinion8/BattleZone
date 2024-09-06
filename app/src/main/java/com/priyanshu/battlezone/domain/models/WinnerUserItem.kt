package com.priyanshu.battlezone.domain.models

import androidx.annotation.DrawableRes

data class WinnerUserItem(
    val name: String,
    @DrawableRes
    val image: Int,
    val position: Int,
    val gameHockRank: Int
)