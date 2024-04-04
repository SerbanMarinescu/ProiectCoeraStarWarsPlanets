package com.example.coeraproject.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coeraproject.data.repository.PlanetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetsViewModel @Inject constructor(
    private val repository: PlanetsRepository
) : ViewModel(){

    private val _state = MutableStateFlow(emptyList<String>())
    val state = _state.asStateFlow()


    init {
        viewModelScope.launch {
            repository.getPlanets().collect { planetList ->

                val planetNames = planetList.map { it.name }
                _state.update {
                    planetNames
                }
            }
        }
    }
}