package com.priyanshu.battlezone.domain.models

data class TournamentItem(
    val title: String,
    val duration: String,
    val entryFees: String,
    val maxAllowed: String,
    val enrolled: String,
    val winingPrice: String,
    val isRegistrationOpen: Boolean
)