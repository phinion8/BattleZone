package com.priyanshu.battlezone.ui.components.bottombar.model

import androidx.annotation.DrawableRes
import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.navigation.Screens

data class BottomNavItem(
    @DrawableRes
    val icon: Int,
    val title: String,
    val route: String
)

val bottomNavItems = listOf<BottomNavItem>(
    BottomNavItem(
        icon = R.drawable.ic_home,
        title = "Home",
        route = Screens.Home.route
    ),
    BottomNavItem(
        icon = R.drawable.ic_leaderboard,
        title = "Tournament",
        route = Screens.Leaderboard.route
    ),
    BottomNavItem(
        icon = R.drawable.ic_tournament,
        title = "Leaderboard",
        route = Screens.Tournament.route
    ),
    BottomNavItem(
        icon = R.drawable.ic_profile,
        title = "Profile",
        route = Screens.Profile.route
    )

)