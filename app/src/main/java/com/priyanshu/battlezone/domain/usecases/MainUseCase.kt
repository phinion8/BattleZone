package com.priyanshu.battlezone.domain.usecases

import com.priyanshu.battlezone.domain.models.GameItem
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

}