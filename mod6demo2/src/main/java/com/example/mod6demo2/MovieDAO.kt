package com.example.mod6demo2

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class MovieDAO(
    val dbw: SQLiteDatabase,
    val dbr: SQLiteDatabase
) {

    fun insert(movie: Movie): Long {

        val values = ContentValues()
        values.put(MovieContract.COLUMN_NAME_DIRECTOR, movie.director)
        values.put(MovieContract.COLUMN_NAME_GENRE, movie.genre)
        values.put(MovieContract.COLUMN_NAME_YEAR, movie.year)
        values.put(MovieContract.COLUMN_NAME_TITLE, movie.title)

        return dbw.insert(MovieContract.TABLE_NAME, null, values)
    }

    fun findAll(): List<Movie> {

        val projection = arrayOf(
            BaseColumns._ID,
            MovieContract.COLUMN_NAME_TITLE,
            MovieContract.COLUMN_NAME_GENRE,
            MovieContract.COLUMN_NAME_DIRECTOR,
            MovieContract.COLUMN_NAME_YEAR
        )

        val cursor = dbr.query(
            MovieContract.TABLE_NAME,
            projection,
//            "${MovieContract.COLUMN_NAME_YEAR} > ?",
//            arrayOf(
//                "2000"
//            ),
            null,
            null,
            null,
            null,
            null
        )

        val movieList = mutableListOf<Movie>()

        with(cursor) {
            while (moveToNext()) {
                val movie = Movie(
                    id = getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    title = getString(getColumnIndexOrThrow(MovieContract.COLUMN_NAME_TITLE)),
                    year = getInt(getColumnIndexOrThrow(MovieContract.COLUMN_NAME_YEAR)),
                    genre = getString(getColumnIndexOrThrow(MovieContract.COLUMN_NAME_GENRE)),
                    director = getString(getColumnIndexOrThrow(MovieContract.COLUMN_NAME_DIRECTOR)),
                )
                movieList += movie
            }
        }
        return movieList
    }

}