package com.priyanshu.battlezone.ui.screens.tournament.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyanshu.battlezone.domain.models.UserTournamentItem
import com.priyanshu.battlezone.domain.usecases.MainUseCase
import com.priyanshu.battlezone.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserTournamentViewModel @Inject constructor(
    private val useCase: MainUseCase
): ViewModel() {

    private val _userTournamentList = MutableStateFlow<List<UserTournamentItem>>(emptyList())
    val userTournamentList = _userTournamentList.asStateFlow()

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _error: MutableStateFlow<String?> = MutableStateFlow(null)
    val error = _error.asStateFlow()

    init {
        getUserTournamentList()
    }

    private fun getUserTournamentList() {
        viewModelScope.launch {
            useCase.getUserTournamentList().collect {result->

                when(result){
                    is Result.Loading -> {
                        _loading.value = true
                    }

                    is Result.Success -> {
                        _loading.value = false
                        if (result.data != null)
                            _userTournamentList.value = result.data
                    }

                    is Result.Error -> {
                        _loading.value = false
                    }
                }

            }
        }
    }

}