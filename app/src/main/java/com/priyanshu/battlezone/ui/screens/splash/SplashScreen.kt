package com.priyanshu.battlezone.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.priyanshu.battlezone.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashCompleted: () -> Unit
) {

    LaunchedEffect(key1 = Unit) {
        delay(1500)
        onSplashCompleted()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            modifier = Modifier.clip(CircleShape).size(150.dp),
            painter = painterResource(R.drawable.app_icon),
            contentDescription = "App icon"
        )


    }


}