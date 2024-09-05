package com.priyanshu.battlezone.data.repositories

import com.priyanshu.battlezone.data.DummyData
import com.priyanshu.battlezone.domain.models.GameItem
import com.priyanshu.battlezone.domain.models.TournamentItem
import com.priyanshu.battlezone.domain.models.UserItem
import com.priyanshu.battlezone.domain.repositories.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(): Repository {
    override fun getBannerList(): List<Int> {
        return DummyData.bannerList
    }

    override fun getGameList(): List<GameItem> {
        return DummyData.gameList
    }

    override fun getTournamentList(): List<TournamentItem> {
        return DummyData.tournamentList
    }

    override fun getRecommendationList(): List<UserItem> {
        return DummyData.recommendationList
    }
}