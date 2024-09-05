package com.priyanshu.battlezone.domain.repositories

import com.priyanshu.battlezone.domain.models.GameItem

interface Repository {

    fun getGameList(): List<GameItem>

}