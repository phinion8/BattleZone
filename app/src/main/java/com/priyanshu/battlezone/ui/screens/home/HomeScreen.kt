package com.priyanshu.battlezone.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import com.priyanshu.battlezone.ui.screens.home.components.MainHorizontalPager
import com.priyanshu.battlezone.ui.screens.home.components.SectionBar
import com.priyanshu.battlezone.ui.screens.home.components.TopAppBar
import com.priyanshu.battlezone.ui.screens.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val gameList by viewModel.gameList.collectAsState()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {

        TopAppBar(
            startIcon = R.drawable.ic_user,
            title = "Priyanshu",
            coins = 2456
        )

        Spacer(Modifier.height(24.dp))

        MainHorizontalPager(
            listOf(R.drawable.banner_image_1, R.drawable.banner_image_1, R.drawable.banner_image_1)
        )

        SectionBar("Play Tournament by Games", optionText = "View All", onOptionClick = {

        })

        Spacer(Modifier.height(8.dp))

        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            columns = GridCells.Adaptive((screenWidth / 4).dp),
            content = {
                items(gameList) {
                    ItemGame(it)
                }
            },
        )

        Spacer(Modifier.height(16.dp))

        CreateTournamentSection()

    }

}

