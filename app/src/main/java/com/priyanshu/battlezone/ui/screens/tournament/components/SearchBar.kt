package com.priyanshu.battlezone.ui.screens.tournament.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.ui.theme.gray
import com.priyanshu.battlezone.ui.theme.white

@Composable
fun SearchBar(
    modifier: Modifier,
    onSearchBarClick: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = gray, shape = RoundedCornerShape(12.dp))
            .background(Color.Transparent)
            .clickable {
                onSearchBarClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 16.dp, end = 8.dp),
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = white
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Search",
                style = MaterialTheme.typography.bodyLarge.copy(color = gray)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.clip(CircleShape).width(2.dp).height(20.dp).background(gray)
            )

            Icon(
                modifier = Modifier
                    .size(56.dp)
                    .padding(start = 16.dp, end = 16.dp),
                painter = painterResource(R.drawable.ic_filter),
                contentDescription = "Filter Icon",
                tint = white
            )
        }




    }

}