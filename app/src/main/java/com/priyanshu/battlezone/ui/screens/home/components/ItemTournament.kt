package com.priyanshu.battlezone.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionErrors
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.domain.models.TournamentItem
import com.priyanshu.battlezone.ui.theme.black
import com.priyanshu.battlezone.ui.theme.gray
import com.priyanshu.battlezone.ui.theme.green
import com.priyanshu.battlezone.ui.theme.white

@Composable
fun ItemTournament(
    item: TournamentItem
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    Column(
        modifier = Modifier
            .padding(end = 12.dp, top = 16.dp)
            .width((screenWidth * 0.8).dp)
            .clip(RoundedCornerShape(12.dp))
            .border(width = 1.dp, shape = RoundedCornerShape(12.dp), color = gray)
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(R.drawable.sample_tournament_image),
                contentDescription = item.title,
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(black.copy(alpha = 0.5f))
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    text = if (item.isRegistrationOpen) "Registration Open" else "Registration Closed",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp, color = white)
                )

                Row(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(black.copy(alpha = 0.5f))
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(R.drawable.ic_leaderboard),
                        tint = green,
                        contentDescription = "Trophy"
                    )
                    Text(
                        text = item.winingPrice,
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp, color = white)
                    )
                    Image(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(R.drawable.ic_coin),
                        contentDescription = "Coin"
                    )
                }
            }


        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
        ) {
            Text(
                item.title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.ic_calendar),
                    tint = gray,
                    contentDescription = "Calendar"
                )
                Spacer(Modifier.width(4.dp))
                Text(item.duration, style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.width((screenWidth * 0.8).dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Entry - ${item.entryFees}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(Modifier.width(4.dp))
                    Image(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(R.drawable.ic_coin),
                        contentDescription = "Coin"
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(R.drawable.ic_tournament),
                        contentDescription = "People icon",
                        tint = gray
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        "${item.enrolled} / ${item.maxAllowed}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.width((screenWidth * 0.8).dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "See Tournament Details",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(R.drawable.ic_arrow_forward),
                    contentDescription = "People icon"
                )

            }


        }


    }

}