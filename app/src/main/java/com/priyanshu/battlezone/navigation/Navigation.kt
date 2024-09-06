package com.priyanshu.battlezone.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.priyanshu.battlezone.ui.screens.home.HomeScreen
import com.priyanshu.battlezone.ui.screens.splash.SplashScreen
import com.priyanshu.battlezone.ui.screens.tournament.TournamentScreen
import com.priyanshu.battlezone.ui.screens.tournamentdetails.TournamentDetailsScreen

@Composable
fun SetUpNavigation(
    navController: NavHostController,
    showBottomBar: (Boolean) -> Unit,
    innerPaddingValues: PaddingValues
) {

    NavHost(navController = navController, startDestination = Screens.Splash.route){

        composable(route = Screens.Splash.route){
            showBottomBar(false)
            SplashScreen(
                onSplashCompleted = {
                    navController.navigate(Screens.Home.route)
                }
            )
        }

        composable(route = Screens.Home.route){
            showBottomBar(true)
            HomeScreen(innerPaddingValues)
        }

        composable(route = Screens.Leaderboard.route){
            showBottomBar(true)
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text("Leaderboard")
            }
        }

        composable(route = Screens.Tournament.route){
            showBottomBar(true)
            TournamentScreen(innerPaddingValues, navController = navController)
        }

        composable(route = Screens.Profile.route){
            showBottomBar(true)
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text("Profile")
            }
        }

        composable(route = Screens.TournamentDetails.route){
            showBottomBar(false)
            TournamentDetailsScreen()
        }

    }


}