package com.priyanshu.battlezone.ui.screens.home.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyanshu.battlezone.domain.models.GameItem
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
): ViewModel() {

    private val _gameList: MutableStateFlow<List<GameItem>> = MutableStateFlow(emptyList())
    val gameList = _gameList.asStateFlow()

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _error: MutableStateFlow<String?> = MutableStateFlow(null)
    val error = _error.asStateFlow()

    init {
        getGameList()
    }

    private fun getGameList(){
        viewModelScope.launch {
            useCase.getGameList().collect{result->
                when(result){
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
}