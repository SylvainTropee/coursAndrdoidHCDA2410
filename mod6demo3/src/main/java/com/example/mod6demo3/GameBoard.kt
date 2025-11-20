package com.example.mod6demo3

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GameBoard(
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,
    var name : String,
    var type : String,
    var duration : Int,
    @ColumnInfo(name = "player_number_min")
    var nbPlayerMin : Int,
    var minimunAge : Int
)
