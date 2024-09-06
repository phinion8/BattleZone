package com.priyanshu.battlezone.ui.screens.home.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyanshu.battlezone.domain.models.GameItem
import com.priyanshu.battlezone.domain.models.TournamentItem
import com.priyanshu.battlezone.domain.models.UserItem
import com.priyanshu.battlezone.domain.usecases.MainUseCase
import com.priyanshu.battlezone.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: MainUseCase
) : ViewModel() {

    private val _bannerList: MutableStateFlow<List<Int>> = MutableStateFlow(emptyList())
    val bannerList = _bannerList.asStateFlow()

    private val _gameList: MutableStateFlow<List<GameItem>> = MutableStateFlow(emptyList())
    val gameList = _gameList.asStateFlow()

    private val _tournamentList: MutableStateFlow<List<TournamentItem>> =
        MutableStateFlow(emptyList())
    val tournamentList = _tournamentList.asStateFlow()

    private val _recommendationList: MutableStateFlow<List<UserItem>> = MutableStateFlow(
        emptyList()
    )
    val recommendationList = _recommendationList.asStateFlow()

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val loading = _loading.asStateFlow()

    private val _error: MutableStateFlow<String?> = MutableStateFlow(null)
    val error = _error.asStateFlow()

    init {
        getBannerList()
        getGameList()
        getTournamentList()
        getRecommendationList()
    }

    private fun getRecommendationList(){
        viewModelScope.launch {
            useCase.getRecommendationList().collect{result->

                when (result) {
                    is Result.Loading -> {
                        _loading.value = true
                    }

                    is Result.Success -> {
                        _loading.value = false
                        if (result.data != null)
                            _recommendationList.value = result.data
                    }

                    is Result.Error -> {
                        _loading.value = false
                    }
                }

            }
        }
    }

    private fun getBannerList() {
        viewModelScope.launch {
            useCase.getBannerList().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _loading.value = true
                    }

                    is Result.Success -> {
                        _loading.value = false
                        if (result.data != null)
                            _bannerList.value = result.data
                    }

                    is Result.Error -> {
                        _loading.value = false
                    }
                }
            }
        }
    }

    private fun getGameList() {
        viewModelScope.launch {
            useCase.getGameList().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _loading.value = true
                    }

                    is Result.Success -> {
                        _loading.value = false
                        if (result.data != null)
                            _gameList.value = result.data
                    }

                    is Result.Error -> {
                        _loading.value = false
                        _error.value = result.message
                    }
                }
            }
        }
    }

    private fun getTournamentList() {
        viewModelScope.launch {
            useCase.getTournamentList().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _loading.value = true
                    }

                    is Result.Success -> {
                        _loading.value = false
                        if (result.data != null)
                            _tournamentList.value = result.data
                    }

                    is Result.Error -> {
                        _loading.value = false
                        _error.value = result.message
                    }
                }
            }
        }
    }
}