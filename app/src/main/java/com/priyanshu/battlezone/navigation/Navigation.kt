package com.priyanshu.battlezone.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.priyanshu.battlezone.ui.screens.home.HomeScreen
import com.priyanshu.battlezone.ui.screens.splash.SplashScreen

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
        }

        composable(route = Screens.Tournament.route){
            showBottomBar(true)
        }

        composable(route = Screens.Profile.route){
            showBottomBar(true)
        }

    }


}