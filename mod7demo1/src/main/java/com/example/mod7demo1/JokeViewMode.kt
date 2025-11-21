package com.example.mod7demo1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JokeViewModel(
    private val jokeService: JokeService
) : ViewModel() {

    private val _joke = MutableStateFlow<Joke?>(null)
    val joke = _joke.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _joke.value = jokeService.getRandomJoke()
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])

                return JokeViewModel(
                    CallJokeApi.retrofitService
                ) as T
            }
        }

    }
}