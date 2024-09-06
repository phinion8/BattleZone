package com.priyanshu.battlezone.navigation

sealed class Screens(val route: String) {

    data object Splash: Screens(route = "splash_screen")
    data object Home: Screens(route = "home_screen")
    data object Leaderboard: Screens(route = "leaderboard_screen")
    data object Tournament: Screens(route = "tournament_screen")
    data object Profile: Screens(route = "profile_screen")
    data object TournamentDetails: Screens(route = "tournament_details_screen")
}