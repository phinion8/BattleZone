package com.priyanshu.battlezone.domain.models

import androidx.annotation.DrawableRes

data class UserTournamentItem(
    val title: String,
    val company: String,
    @DrawableRes
    val companyImage: Int,
    val gameName: String,
    val playerGrouping: String,
    val duration: String,
    val pricePool: String,
    val entryFees: String,
    val tournamentStatus: TournamentStatus
)

enum class TournamentStatus {
    COMPLETED,
    UPCOMING,
    ONGOING
}