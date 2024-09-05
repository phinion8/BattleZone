package com.priyanshu.battlezone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.priyanshu.battlezone.ui.screens.splash.SplashScreen

@Composable
fun SetUpNavigation(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Screens.Splash.route){

        composable(route = Screens.Splash.route){
            SplashScreen(
                onSplashCompleted = {
                    navController.navigate(Screens.Home.route)
                }
            )
        }

        composable(route = Screens.Home.route){



        }

        composable(route = Screens.Leaderboard.route){

        }

        composable(route = Screens.Tournament.route){

        }

        composable(route = Screens.Profile.route){

        }

    }


}