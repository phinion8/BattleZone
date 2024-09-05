package com.priyanshu.battlezone.data

import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.domain.models.GameItem
import com.priyanshu.battlezone.domain.models.TournamentItem
import com.priyanshu.battlezone.domain.models.UserItem

object DummyData {

    val bannerList = listOf(
        R.drawable.banner_image_1, R.drawable.banner_image_1, R.drawable.banner_image_1
    )

    val recommendationList = listOf(
        UserItem(
            image = R.drawable.sample_user_1,
            name = "Legend Gamer"
        ),
        UserItem(
            image = R.drawable.sample_user_2,
            name = "Priyanshu Verma"
        ),
        UserItem(
            image = R.drawable.sample_user_3,
            name = "Legend Gamer"
        )
    )

    val gameList = listOf(
        GameItem(R.drawable.pubg, "PUBG"),
        GameItem(R.drawable.valorent, "Valorent"),
        GameItem(R.drawable.apex_legends, "Apex Legends"),
        GameItem(R.drawable.call_of_duty, "Call of Duty"),
        GameItem(R.drawable.counter_strike, "Counter Strike"),
        GameItem(R.drawable.pubg, "PUBG"),
        )

    val tournamentList = listOf(
        TournamentItem(
            title = "PUBG Tournament By Red Bull",
            duration = "Jun 26 - Jun 27, 2024",
            entryFees = "10",
            maxAllowed = "800",
            enrolled = "670",
            winingPrice = "10000",
            isRegistrationOpen = true
        ),
        TournamentItem(
            title = "PUBG tournament  By Red Bull",
            duration = "Jun 26 - Jun 27, 2024",
            entryFees = "10",
            maxAllowed = "800",
            enrolled = "670",
            winingPrice = "10000",
            isRegistrationOpen = true
        ),
        TournamentItem(
            title = "PUBG tournament  By Red Bull",
            duration = "Jun 26 - Jun 27, 2024",
            entryFees = "10",
            maxAllowed = "800",
            enrolled = "670",
            winingPrice = "10000",
            isRegistrationOpen = true
        )
    )

}