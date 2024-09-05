package com.priyanshu.battlezone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.priyanshu.battlezone.navigation.SetUpNavigation
import com.priyanshu.battlezone.ui.components.bottombar.BottomNavBar
import com.priyanshu.battlezone.ui.components.bottombar.model.bottomNavItems
import com.priyanshu.battlezone.ui.theme.BattleZoneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var showBottomBar by remember {
                mutableStateOf(false)
            }
            BattleZoneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(modifier = Modifier.fillMaxSize(),
                        content = { innerPadding ->
                            SetUpNavigation(navController,
                                showBottomBar = {
                                    showBottomBar = it
                                })
                        },
                        bottomBar = {
                            if (showBottomBar) {
                                BottomNavBar(
                                    modifier = Modifier.fillMaxWidth(),
                                    bottomNavItems = bottomNavItems,
                                    navController = navController,
                                    onItemClick = {
                                        navController.navigate(it.route) {
                                            popUpTo(navController.graph.startDestinationId) {
                                                saveState = true
                                            }
                                            this.launchSingleTop = true
                                            this.restoreState = true
                                        }
                                    })
                            }
                        }
                    )
                }
            }
        }
    }
}

