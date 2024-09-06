package com.priyanshu.battlezone.domain.repositories

import com.priyanshu.battlezone.domain.models.GameItem
import com.priyanshu.battlezone.domain.models.TournamentItem
import com.priyanshu.battlezone.domain.models.UserItem
import com.priyanshu.battlezone.domain.models.UserTournamentItem
import com.priyanshu.battlezone.domain.models.WinnerUserItem

interface Repository {

    fun getBannerList(): List<Int>
    fun getGameList(): List<GameItem>
    fun getTournamentList(): List<TournamentItem>
    fun getRecommendationList(): List<UserItem>
    fun getUserTournamentList(): List<UserTournamentItem>
    fun getWinnerUserList(): List<WinnerUserItem>
}