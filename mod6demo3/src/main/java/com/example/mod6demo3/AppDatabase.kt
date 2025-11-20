package com.example.mod6demo3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GameBoard::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    //liste des daos
    abstract fun getGameBoardDao(): GameBoardDAO

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            var instance = INSTANCE

            if (instance == null) {

                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "mod6demo3.db"
                ).build()

                INSTANCE = instance
            }
            return instance
        }
    }


}