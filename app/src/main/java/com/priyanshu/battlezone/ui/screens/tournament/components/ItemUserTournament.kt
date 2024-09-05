package com.priyanshu.battlezone.ui.screens.tournament.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.domain.models.TournamentItem
import com.priyanshu.battlezone.domain.models.TournamentStatus
import com.priyanshu.battlezone.domain.models.UserTournamentItem
import com.priyanshu.battlezone.ui.theme.black
import com.priyanshu.battlezone.ui.theme.cream
import com.priyanshu.battlezone.ui.theme.gray
import com.priyanshu.battlezone.ui.theme.green
import com.priyanshu.battlezone.ui.theme.orange
import com.priyanshu.battlezone.ui.theme.white

@Composable
fun ItemUserTournament(
    item: UserTournamentItem
) {

    Column(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(width = 1.dp, shape = RoundedCornerShape(12.dp), color = gray)
            .padding(all = 16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    item.title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "By ${item.company}", style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.sample_company_img),
                contentDescription = item.company
            )
        }

        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(green.copy(alpha = 0.5f))
                    .padding(all = 4.dp),
                text = item.gameName,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 12.sp
                )
            )
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(green.copy(alpha = 0.5f))
                    .padding(all = 4.dp),
                text = item.playerGrouping,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 12.sp
                )
            )
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(green.copy(alpha = 0.5f))
                    .padding(all = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Entry-${item.entryFees}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 12.sp
                    )
                )
                Image(
                    modifier = Modifier.size(12.dp),
                    painter = painterResource(R.drawable.ic_coin),
                    contentDescription = "Coin"
                )
            }

        }

        Spacer(Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(16.dp),
                painter = painterResource(R.drawable.ic_timer),
                contentDescription = "Calendar"
            )
            Spacer(Modifier.width(4.dp))
            Text(item.duration, style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.ic_header_trophy),
                    contentDescription = "People icon"
                )

                Text(
                    text = "Price Pool - ${item.pricePool}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.ic_coin),
                    contentDescription = "People icon"
                )

            }

            when (
                item.tournamentStatus
            ) {
                TournamentStatus.ONGOING -> {
                    Text(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(orange)
                            .padding(vertical = 4.dp, horizontal = 8.dp),
                        text = "Ongoing",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 12.sp,
                            color = white
                        )
                    )
                }

                TournamentStatus.COMPLETED -> {
                    Text(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(green)
                            .padding(vertical = 4.dp, horizontal = 8.dp),
                        text = "Completed",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 12.sp,
                            color = white
                        )
                    )

                }

                TournamentStatus.UPCOMING -> {
                    Text(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(cream)
                            .padding(vertical = 4.dp, horizontal = 8.dp),
                        text = "Upcoming",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 12.sp,
                            color = black
                        )
                    )

                }
            }


        }


    }


}