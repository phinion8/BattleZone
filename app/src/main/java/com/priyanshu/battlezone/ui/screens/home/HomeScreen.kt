package com.priyanshu.battlezone.ui.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.ui.screens.home.components.CreateTournamentSection
import com.priyanshu.battlezone.ui.screens.home.components.ItemGame
import com.priyanshu.battlezone.ui.screens.home.components.ItemRecommendation
import com.priyanshu.battlezone.ui.screens.home.components.ItemTournament
import com.priyanshu.battlezone.ui.screens.home.components.MainHorizontalPager
import com.priyanshu.battlezone.ui.screens.home.components.SectionBar
import com.priyanshu.battlezone.ui.components.appbar.TopAppBar
import com.priyanshu.battlezone.ui.screens.home.components.HomeLoadingLayout
import com.priyanshu.battlezone.ui.screens.home.viewmodel.HomeViewModel
import com.priyanshu.battlezone.utils.isScrollingUp

@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val loading by viewModel.loading.collectAsState()
    val gameList by viewModel.gameList.collectAsState()
    val tournamentList by viewModel.tournamentList.collectAsState()
    val bannerList by viewModel.bannerList.collectAsState()
    val recommendationList by viewModel.recommendationList.collectAsState()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp
    val lazyListState = rememberLazyListState()
    val topBarVisibility = lazyListState.isScrollingUp()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = innerPadding.calculateBottomPadding()
            ),
    ) {

        AnimatedVisibility(
            visible = topBarVisibility,
            exit = shrinkVertically(),
            enter = expandVertically()
        ) {
            TopAppBar(
                startIcon = R.drawable.ic_user, title = "Priyanshu", coins = 2456
            )
        }

        if (loading) {

            Spacer(Modifier.height(24.dp))
            HomeLoadingLayout(lazyListState)

        } else {
            LazyColumn(
                state = lazyListState
            ) {
                item {
                    Spacer(Modifier.height(24.dp))
                    MainHorizontalPager(
                        bannerList
                    )
                }

                item {
                    SectionBar(
                        title = "Play Tournament by Games",
                        optionText = "View all",
                        onOptionClick = {

                        }
                    )

                    Spacer(Modifier.height(8.dp))
                }

                item {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((screenHeight / 3.2).dp),
                        columns = GridCells.Adaptive((screenWidth / 4).dp),
                        content = {
                            items(gameList) {
                                ItemGame(it)
                            }
                        },
                    )

                    Spacer(Modifier.height(16.dp))
                }

                item {
                    CreateTournamentSection()
                    Spacer(Modifier.height(16.dp))
                }

                item {
                    SectionBar(
                        title = "Compete in Battles",
                        optionText = "View all",
                        onOptionClick = {
                        }
                    )
                }


                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(tournamentList) {
                            ItemTournament(it)
                        }
                    }

                    Spacer(Modifier.height(16.dp))
                }

                item {
                    SectionBar(
                        title = "People to follow",
                        optionText = "View more",
                        onOptionClick = {

                        }
                    )

                    Spacer(Modifier.height(16.dp))
                }

                items(recommendationList) {
                    ItemRecommendation(it)
                }
            }


        }


    }

}

