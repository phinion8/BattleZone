package com.priyanshu.battlezone.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.ui.theme.cream

@Composable
fun CreateTournamentSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(cream)
            .padding(all = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text(
                text = "Create your own Tournaments",
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 18.sp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Host and manage your own tournaments and play with your friends",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Image(
            modifier = Modifier.fillMaxSize(0.25f),
            painter = painterResource(R.drawable.game_controller),
            contentDescription = "Game Controller"
        )

    }

}