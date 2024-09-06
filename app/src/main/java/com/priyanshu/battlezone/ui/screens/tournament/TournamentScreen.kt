package com.priyanshu.battlezone.ui.screens.tournament

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.navigation.Screens
import com.priyanshu.battlezone.ui.components.appbar.TopAppBar
import com.priyanshu.battlezone.ui.screens.tournament.components.ItemUserTournament
import com.priyanshu.battlezone.ui.screens.tournament.components.SearchBar
import com.priyanshu.battlezone.ui.screens.tournament.components.UserTournamentsDetails
import com.priyanshu.battlezone.ui.screens.tournament.viewmodel.UserTournamentViewModel
import com.priyanshu.battlezone.ui.theme.green

@Composable
fun TournamentScreen(
    innerPaddingValues: PaddingValues,
    viewModel: UserTournamentViewModel = hiltViewModel(),
    navController: NavController
) {

    val userTournamentList by viewModel.userTournamentList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 8.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = innerPaddingValues.calculateBottomPadding()
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            TopAppBar(
                startIcon = R.drawable.ic_header_trophy, title = "Tournaments", coins = 2456
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            UserTournamentsDetails()
            Spacer(Modifier.height(16.dp))
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SearchBar(modifier = Modifier.weight(2f), onSearchBarClick = {

                })
                Spacer(Modifier.width(16.dp))
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(green)
                        .padding(
                            vertical = 16.dp, horizontal = 16.dp
                        ),
                    text = "+Create",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                )
            }
            Spacer(Modifier.height(16.dp))
        }

        items(userTournamentList){
            ItemUserTournament(
                it,
                onItemClick = {
                    navController.navigate(Screens.TournamentDetails.route)
                }
            )
        }

    }
}