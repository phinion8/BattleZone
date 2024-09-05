package com.priyanshu.battlezone.domain.models

import androidx.annotation.DrawableRes

data class UserItem(
    @DrawableRes
    val image: Int,
    val name: String,
)