package com.example.mod6demo3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameBoardViewModel(
    private val gameBoardRepository: GameBoardRepository
) : ViewModel() {

    private val _games = MutableStateFlow<List<GameBoard>>(emptyList())
    val games = _games.asStateFlow()

    init {
        val gb1 = GameBoard(
            name = "Papayoo",
            duration = 30,
            minimunAge = 7,
            nbPlayerMin = 3,
            type = "Ambiance"
        )
        val gb2 = GameBoard(
            name = "Mojo",
            duration = 30,
            minimunAge = 8,
            nbPlayerMin = 3,
            type = "Ambiance"
        )


        viewModelScope.launch(Dispatchers.IO) {
            gameBoardRepository.addGameBoard(gb1)
            gameBoardRepository.addGameBoard(gb2)
            _games.value = gameBoardRepository.getAllGameBoard()

//            val  a = async {}.await()
//            val b = async {}
//            awaitAll(a, b)
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

                return GameBoardViewModel(
                    GameBoardRepository(
                        AppDatabase.getInstance(application.applicationContext).getGameBoardDao()
                    )
                ) as T
            }
        }

    }
}