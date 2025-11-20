package com.example.mod6demo3

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GameBoardDAO {

    @Insert
    suspend fun insert(gameBoard: GameBoard) : Long

    @Update
    suspend fun update(gameBoard: GameBoard)

    @Delete
    suspend fun delete(gameBoard: GameBoard)

    @Query("SELECT * FROM GameBoard")
    suspend fun findAll() : List<GameBoard>

    @Query("SELECT * FROM GameBoard WHERE id = :id")
    suspend fun findById(id : Long) : GameBoard

}