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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.ui.theme.black
import com.priyanshu.battlezone.ui.theme.cream

@Composable
fun CreateTournamentSection() {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(cream)
            .padding(vertical = 8.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier.weight(4f)
        ) {
            Text(
                text = "Create your own Tournaments",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 14.sp,
                    color = black,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = "Host and manage your own tournaments and play with your friends",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 13.sp,
                    lineHeight = 16.sp,
                    color = black
                )
            )
        }

        Image(
            modifier = Modifier
                .size((screenWidth/5).dp)
                .weight(1f),
            painter = painterResource(R.drawable.game_controller),
            contentDescription = "Game Controller"
        )

    }

}