package com.denreyes.puplist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denreyes.puplist.data.Dog
import com.denreyes.puplist.data.DogsRepository
import com.denreyes.puplist.data.NetworkResult
import com.denreyes.puplist.views.DogsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DogsViewModel(
    private val dogsRepository: DogsRepository
): ViewModel() {
    val dogsUIState = MutableStateFlow(DogsUIState())

    init {
        getDogs()
    }

    private fun getDogs() {
        dogsUIState.value = DogsUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = dogsRepository.getDogs()) {
                is NetworkResult.Success -> {
                    dogsUIState.update {
                        it.copy(isLoading = false, dogs = result.data)
                    }
                }
                is NetworkResult.Error -> {
                    dogsUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }
}
