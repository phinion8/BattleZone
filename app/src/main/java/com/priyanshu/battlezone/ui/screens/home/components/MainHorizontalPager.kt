package com.priyanshu.battlezone.ui.screens.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.priyanshu.battlezone.ui.theme.gray
import com.priyanshu.battlezone.ui.theme.primaryColor
import com.priyanshu.battlezone.ui.theme.white

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainHorizontalPager(
    imageList: List<Int>
) {
    val pagerState = rememberPagerState(
        pageCount = {
            imageList.size
        }
    )
    Column {
        HorizontalPager(
            state = pagerState,
            pageContent = {
                imageList.forEach {
                    PagerItem(it)
                }
            }
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            content = {
                items(imageList.size) {
                    PagerIndicator(selected = pagerState.currentPage == it)
                }
            }
        )
    }


}

@Composable
fun PagerItem(
    @DrawableRes
    image: Int
) {

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.25f)
            .clip(RoundedCornerShape(12.dp)),
        painter = painterResource(image),
        contentDescription = "Carousal Image",
        contentScale = ContentScale.Crop
    )

}

@Composable
fun PagerIndicator(
    selected: Boolean = false
) {

    Box(
        modifier = Modifier
            .padding(horizontal = 6.dp, vertical = 16.dp)
            .size(10.dp)
            .clip(CircleShape)
            .background(if (selected) primaryColor else gray)
    )

}