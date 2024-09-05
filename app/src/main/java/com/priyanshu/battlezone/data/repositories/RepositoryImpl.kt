package com.priyanshu.battlezone.data.repositories

import com.priyanshu.battlezone.data.DummyData
import com.priyanshu.battlezone.domain.models.GameItem
import com.priyanshu.battlezone.domain.repositories.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(): Repository {
    override fun getGameList(): List<GameItem> {
        return DummyData.gameList
    }
}