package com.priyanshu.battlezone.data

import com.priyanshu.battlezone.R
import com.priyanshu.battlezone.domain.models.GameItem
import com.priyanshu.battlezone.domain.models.TournamentItem
import com.priyanshu.battlezone.domain.models.TournamentStatus
import com.priyanshu.battlezone.domain.models.UserItem
import com.priyanshu.battlezone.domain.models.UserTournamentItem

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

    val userTournamentList = listOf(
        UserTournamentItem(
            title = "PUBG Tournament",
            company = "Red Bull",
            companyImage = R.drawable.sample_company_img,
            gameName = "PUBG",
            playerGrouping = "Solo",
            duration = "Starts 3rd Aug at 10:00 pm",
            pricePool = "10000",
            entryFees = "10",
            tournamentStatus = TournamentStatus.UPCOMING
        ),
        UserTournamentItem(
            title = "PUBG Tournament",
            company = "Red Bull",
            companyImage = R.drawable.sample_company_img,
            gameName = "PUBG",
            playerGrouping = "Solo",
            duration = "Starts 3rd Aug at 10:00 pm",
            pricePool = "10000",
            entryFees = "10",
            tournamentStatus = TournamentStatus.ONGOING
        ),
        UserTournamentItem(
            title = "PUBG Tournament",
            company = "Red Bull",
            companyImage = R.drawable.sample_company_img,
            gameName = "PUBG",
            playerGrouping = "Solo",
            duration = "Starts 3rd Aug at 10:00 pm",
            pricePool = "10000",
            entryFees = "10",
            tournamentStatus = TournamentStatus.COMPLETED
        ),
        UserTournamentItem(
            title = "PUBG Tournament",
            company = "Red Bull",
            companyImage = R.drawable.sample_company_img,
            gameName = "PUBG",
            playerGrouping = "Solo",
            duration = "Starts 3rd Aug at 10:00 pm",
            pricePool = "10000",
            entryFees = "10",
            tournamentStatus = TournamentStatus.COMPLETED
        )
    )

}