package com.example.mod6demo2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MovieDbHelper(context: Context) : SQLiteOpenHelper(
    context,
    MovieContract.DATABASE_NAME,
    null,
    MovieContract.VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MovieContract.CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL(MovieContract.DROP_TABLE_QUERY)
        onCreate(db)
    }
}