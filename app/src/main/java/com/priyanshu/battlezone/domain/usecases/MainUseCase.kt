package com.priyanshu.battlezone.domain.usecases

import com.priyanshu.battlezone.data.DummyData
import com.priyanshu.battlezone.domain.models.GameItem
import com.priyanshu.battlezone.domain.models.TournamentItem
import com.priyanshu.battlezone.domain.models.UserItem
import com.priyanshu.battlezone.domain.models.UserTournamentItem
import com.priyanshu.battlezone.domain.models.WinnerUserItem
import com.priyanshu.battlezone.domain.repositories.Repository
import com.priyanshu.battlezone.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val repository: Repository
) {
    fun getWinnerUserList(): Flow<Result<List<WinnerUserItem>>> = flow {
        emit(Result.Loading())
        delay(1000)
        try {
            val winnerUserList = DummyData.winnerUserList
            emit(Result.Success(winnerUserList))
        } catch (e: Exception) {
            emit(Result.Error("Something went wrong!"))
        }
    }.catch {
        emit(Result.Error("Something went wrong!"))
    }.flowOn(Dispatchers.IO)

    fun getUserTournamentList(): Flow<Result<List<UserTournamentItem>>> = flow {
        emit(Result.Loading())
        delay(1000)
        try {
            val userTournamentList = repository.getUserTournamentList()
            emit(Result.Success(userTournamentList))
        } catch (e: Exception) {
            emit(Result.Error("Something went wrong!"))
        }
    }.catch {
        emit(Result.Error("Something went wrong!"))
    }.flowOn(Dispatchers.IO)

    fun getRecommendationList(): Flow<Result<List<UserItem>>> = flow {
        emit(Result.Loading())
        delay(1000)
        try {
            val recommendationList = repository.getRecommendationList()
            emit(Result.Success(recommendationList))
        } catch (e: Exception) {
            emit(Result.Error("Something went wrong!"))
        }
    }.catch {
        emit(Result.Error("Something went wrong!"))
    }.flowOn(Dispatchers.IO)

    fun getBannerList(): Flow<Result<List<Int>>> = flow {
        emit(Result.Loading())
        delay(1000)
        try {
            val bannerList = repository.getBannerList()
            emit(Result.Success(bannerList))
        } catch (e: Exception) {
            emit(Result.Error("Something went wrong!"))
        }
    }.catch {
        emit(Result.Error("Something went wrong!"))
    }.flowOn(Dispatchers.IO)

    fun getGameList(): Flow<Result<List<GameItem>>> = flow {
        emit(Result.Loading())
        delay(1000)
        try {
            val gameList = repository.getGameList()
            emit(Result.Success(gameList))
        } catch (e: Exception) {
            emit(Result.Error("Something went wrong!"))
        }

    }.catch {
        emit(Result.Error("Something went wrong!"))
    }.flowOn(Dispatchers.IO)

    fun getTournamentList(): Flow<Result<List<TournamentItem>>> = flow {
        emit(Result.Loading())
        delay(1000)
        try {
            val gameList = repository.getTournamentList()
            emit(Result.Success(gameList))
        } catch (e: Exception) {
            emit(Result.Error("Something went wrong!"))
        }

    }.catch {
        emit(Result.Error("Something went wrong!"))
    }.flowOn(Dispatchers.IO)

}