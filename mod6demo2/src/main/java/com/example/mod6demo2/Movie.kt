package com.example.mod6demo2

import android.provider.BaseColumns

data class Movie(
    var id : Long = 0,
    var title : String,
    var year: Int,
    var genre : String,
    var director : String
)

object MovieContract{

    val TABLE_NAME = "movies"

    val COLUMN_NAME_TITLE = "title"
    val COLUMN_NAME_YEAR = "year"
    val COLUMN_NAME_GENRE = "genre"
    val COLUMN_NAME_DIRECTOR = "director"

    val DATABASE_NAME = "mod6demo2.db"
    val VERSION = 1

    val CREATE_TABLE_QUERY = """
        CREATE TABLE $TABLE_NAME
        (
            ${BaseColumns._ID} INTEGER PRIMARY KEY,
            $COLUMN_NAME_TITLE TEXT NOT NULL,
            $COLUMN_NAME_YEAR INTEGER NULL,
            $COLUMN_NAME_GENRE TEXT NOT NULL,
            $COLUMN_NAME_DIRECTOR TEXT NOT NULL
        )
    """.trimIndent()

    val DROP_TABLE_QUERY = "DROP TABLE IF EXISTS $TABLE_NAME"






}
