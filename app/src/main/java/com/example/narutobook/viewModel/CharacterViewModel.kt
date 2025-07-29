package com.example.narutobook.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.narutobook.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.narutobook.model.Character

class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchCharacters()
    }

    fun fetchCharacters() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = repository.fetchCharacters()
            _characters.value = result
            _isLoading.value = false
        }
    }
}

