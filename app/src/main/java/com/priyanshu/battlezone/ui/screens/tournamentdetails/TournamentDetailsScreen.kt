package com.priyanshu.battlezone.ui.screens.tournamentdetails

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.navDeepLink
import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.data.DummyData
import com.priyanshu.battlezone.domain.models.UserItem
import com.priyanshu.battlezone.domain.models.WinnerUserItem
import com.priyanshu.battlezone.ui.components.button.CustomElevatedButton
import com.priyanshu.battlezone.ui.screens.tournament.components.TournamentDetailsLoadingLayout
import com.priyanshu.battlezone.ui.screens.tournamentdetails.components.ItemLeaderboardUser
import com.priyanshu.battlezone.ui.screens.tournamentdetails.viewmodel.TournamentDetailsViewModel
import com.priyanshu.battlezone.ui.theme.black
import com.priyanshu.battlezone.ui.theme.gray
import com.priyanshu.battlezone.ui.theme.green
import com.priyanshu.battlezone.ui.theme.poppins_semiBold
import com.priyanshu.battlezone.ui.theme.primaryColor
import com.priyanshu.battlezone.ui.theme.secondaryColor
import com.priyanshu.battlezone.ui.theme.white
import com.priyanshu.battlezone.utils.isScrollingUp

@Composable
fun TournamentDetailsScreen(
    viewModel: TournamentDetailsViewModel = hiltViewModel()
) {

    val winnerUserList by viewModel.winnerUserList.collectAsState()
    val loading by viewModel.loading.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.weight(9f)
        ) {
            TournamentDetailsHeader()

            TournamentTabSection(
                winnerUserList,
                isLoading = loading
            )

        }

        CustomElevatedButton(
            modifier = Modifier.weight(0.6f),
            onClick = {

            },
            text = "Join Tournament"
        )
    }

}

@Composable
fun TournamentDetailsHeader() {
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeightDp / 4).dp),
            contentAlignment = Alignment.BottomEnd,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height((screenHeightDp / 4).dp),
                painter = painterResource(R.drawable.sample_tournament_details_img),
                contentDescription = "Tournament Details Image",
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp, end = 8.dp)
                    .clip(CircleShape)
                    .background(black.copy(alpha = 0.5f))
                    .padding(vertical = 4.dp, horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.ic_tournament),
                    contentDescription = "Calendar",
                    tint = white
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = "670/800",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 14.sp,
                        color = white
                    )
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        "PUBG Tournament",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Entry - 10", style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(Modifier.width(2.dp))
                        Image(
                            modifier = Modifier.size(14.dp),
                            painter = painterResource(R.drawable.ic_coin),
                            contentDescription = "Coin icon"
                        )
                    }

                }

                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    painter = painterResource(R.drawable.sample_company_img),
                    contentDescription = "Company Image"
                )
            }

        }


    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TournamentTabSection(
    winnerUserList: List<WinnerUserItem>,
    isLoading: Boolean
) {
    val lazyListState = rememberLazyListState()
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val tabItems = listOf("Standings", "Overview", "Rules")
    val pagerState = rememberPagerState {
        tabItems.size
    }

    LaunchedEffect(key1 = selectedTabIndex) {
        pagerState.scrollToPage(selectedTabIndex)
    }

    LaunchedEffect(key1 = pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress)
            selectedTabIndex = pagerState.currentPage
    }
    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,

            ) {

            tabItems.forEachIndexed { index, tabItem ->
                val selected = index == selectedTabIndex
                Tab(
                    modifier = Modifier.background(MaterialTheme.colorScheme.background),
                    selected = selected,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = { Text(text = tabItem, style = MaterialTheme.typography.bodyLarge) },
                    unselectedContentColor = gray,
                    selectedContentColor = primaryColor,
                )
            }

        }
        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            Column(modifier = Modifier.fillMaxWidth()) {
                when (index) {
                    0 -> {
                        StandingSection(lazyListState, winnerUserList, isLoading)
                    }

                    1 -> {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = tabItems[index])
                        }
                    }

                    2 -> {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = tabItems[index])
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun StandingSection(
    lazyListState: LazyListState,
    winnerUserList: List<WinnerUserItem>,
    isLoading: Boolean
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        state = lazyListState
    ) {

        if (isLoading) {
            item {
                CircularProgressIndicator(
                    strokeCap = StrokeCap.Round,
                    color = green
                )
            }
        } else {
            if (winnerUserList.isNotEmpty()) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        WinnerUserPositionItem(
                            modifier = Modifier.offset(y = 64.dp),
                            winnerUserList[1],
                            50.dp
                        )

                        WinnerUserPositionItem(
                            modifier = Modifier.offset(y = 0.dp),
                            winnerUserList[0],
                            64.dp
                        )

                        WinnerUserPositionItem(
                            modifier = Modifier.offset(y = 72.dp),
                            winnerUserList[2],
                            50.dp
                        )
                    }
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp, vertical = 4.dp)
                            .height((screenHeight / 5).dp),
                        painter = painterResource(R.drawable.position_image),
                        contentDescription = "Position Image"
                    )

                    Spacer(Modifier.height(16.dp))
                }

                items(winnerUserList.subList(3, DummyData.winnerUserList.size)) {
                    ItemLeaderboardUser(it)
                }
            }
        }
    }

}

@Composable
fun WinnerUserPositionItem(
    modifier: Modifier,
    item: WinnerUserItem,
    imageSize: Dp
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(imageSize),
            painter = painterResource(item.image),
            contentDescription = "Winner User Image"
        )
        Spacer(Modifier.height(4.dp))
        Text(item.name, style = MaterialTheme.typography.bodyMedium)
        Text(
            if (item.position <= 1) "GameHok Rank\n${item.gameHockRank}" else "GRank\n${item.gameHockRank}",
            style = MaterialTheme.typography.bodySmall.copy(
                textAlign = TextAlign.Center,
                lineHeight = 16.sp
            )
        )
    }

}
