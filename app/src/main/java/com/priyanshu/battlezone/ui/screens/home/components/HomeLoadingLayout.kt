package com.priyanshu.battlezone.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.priyanshu.battlezone.ui.components.loading.shimmerLoadingAnimation

@Composable
fun HomeLoadingLayout(
    lazyListState: LazyListState
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        state = lazyListState
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .height(180.dp)
                    .shimmerLoadingAnimation()
            )
        }
        item {
            Box(
                modifier = Modifier
                    .height(24.dp)
                    .fillMaxWidth(0.5f)
                    .clip(RoundedCornerShape(16.dp))
                    .shimmerLoadingAnimation()
            )
        }
        item {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .height((screenHeight / 3.2).dp),
                columns = GridCells.Fixed(count = 3),
                content = {
                    items(6) {
                        Box(
                            Modifier
                                .padding(all = 8.dp)
                                .fillMaxWidth()
                                .height((screenHeight / 7.2).dp)
                                .clip(RoundedCornerShape(12.dp))
                                .shimmerLoadingAnimation()
                        )
                    }
                },
            )
            Spacer(Modifier.height(16.dp))
        }
        items(5) {
            Box(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .shimmerLoadingAnimation()
            )
        }
    }
}