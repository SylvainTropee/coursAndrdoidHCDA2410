package com.example.mod6demo3

class GameBoardRepository(
    private val gameBoardDAO: GameBoardDAO
) {

    suspend fun addGameBoard(gameBoard: GameBoard): Long {
        return gameBoardDAO.insert(gameBoard)
    }

    suspend fun getAllGameBoard(): List<GameBoard> {
        return gameBoardDAO.findAll()
    }

}