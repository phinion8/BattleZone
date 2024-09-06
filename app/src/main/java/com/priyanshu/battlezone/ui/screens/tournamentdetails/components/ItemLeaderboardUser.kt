package com.priyanshu.battlezone.ui.screens.tournamentdetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.domain.models.WinnerUserItem
import com.priyanshu.battlezone.ui.theme.green

@Composable
fun ItemLeaderboardUser(
    item: WinnerUserItem
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                modifier = Modifier.size(42.dp),
                painter = painterResource(item.image),
                contentDescription = item.name
            )

            Column {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Normal)
                )
                Spacer(Modifier.size(4.dp))
                Text(
                    text = "Gamehok Rank - ${item.gameHockRank}",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Normal)
                )
            }

        }

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(green.copy(alpha = 0.5f))
                .padding(
                    vertical = 4.dp, horizontal = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(16.dp),
                painter = painterResource(R.drawable.ic_ranking),
                contentDescription = "Ranking icon"
            )
            Spacer(Modifier.width(2.dp))
            Text(
                text = if (item.position < 10) "0${item.position}" else "${item.position}",
                style = MaterialTheme.typography.bodyLarge
            )
        }



    }

}