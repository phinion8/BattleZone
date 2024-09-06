package com.priyanshu.battlezone.ui.screens.tournamentdetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyanshu.battlezone.domain.models.WinnerUserItem
import com.priyanshu.battlezone.domain.usecases.MainUseCase
import com.priyanshu.battlezone.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TournamentDetailsViewModel @Inject constructor(
    private val useCase: MainUseCase
) : ViewModel() {

    private val _winnerUserList: MutableStateFlow<List<WinnerUserItem>> =
        MutableStateFlow(emptyList())
    val winnerUserList = _winnerUserList.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    init {
        getWinnerUserList()
    }

    private fun getWinnerUserList() {
        viewModelScope.launch {
            useCase.getWinnerUserList().collect { result ->

                when (result) {

                    is Result.Loading -> {
                        _loading.value = true
                    }

                    is Result.Success -> {
                        _loading.value = false
                        if (result.data != null)
                            _winnerUserList.value = result.data
                    }

                    is Result.Error -> {
                        _loading.value = false
                    }
                }

            }
        }
    }

}