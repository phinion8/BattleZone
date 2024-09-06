package com.priyanshu.battlezone.ui.screens.tournament.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.priyanshu.battlezone.ui.theme.gray
import com.priyanshu.battlezone.ui.theme.mildGreen
import com.priyanshu.battlezone.ui.theme.softGreen
import com.priyanshu.battlezone.ui.theme.white

@Composable
fun UserTournamentsDetails() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(brush = Brush.verticalGradient(colors = listOf(softGreen, mildGreen)))
            .padding(all = 16.dp)
    ) {

        Text(
            "Total Tournaments - 47",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = white
            )
        )

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TournamentTypeDetail(key = "Won", value = "06")
            TournamentTypeDetail(key = "Top 3", value = "02")
            TournamentTypeDetail(key = "Rank (3-10)", value = "04")
            TournamentTypeDetail(key = "Lost", value = "10")
        }

    }
}

@Composable
fun TournamentTypeDetail(
    key: String,
    value: String
) {
    Column {
        Text(key, style = MaterialTheme.typography.bodyMedium.copy(color = gray))
        Text(value, style = MaterialTheme.typography.bodyLarge.copy(color = white))
    }

}
