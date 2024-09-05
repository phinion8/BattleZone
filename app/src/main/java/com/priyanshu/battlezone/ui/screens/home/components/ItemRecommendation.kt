package com.priyanshu.battlezone.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.priyanshu.battlezone.domain.models.UserItem
import com.priyanshu.battlezone.ui.theme.green

@Composable
fun ItemRecommendation(
    recommendationItem: UserItem
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                modifier = Modifier.size(35.dp),
                painter = painterResource(recommendationItem.image),
                contentDescription = recommendationItem.name
            )

            Text(
                recommendationItem.name,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
            )

        }

        Text(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(green.copy(alpha = 0.5f))
                .padding(
                    vertical = 8.dp, horizontal = 16.dp
                ),
            text = "Follow",
            style = MaterialTheme.typography.bodyMedium
        )


    }

}