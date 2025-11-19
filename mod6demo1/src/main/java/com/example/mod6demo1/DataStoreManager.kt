package com.example.mod6demo1

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object DataStoreManager {

    private val Context.datastore by preferencesDataStore("user_settings")

    private val KEY_BG_COLOR = intPreferencesKey("KEY_BG_COLOR")

    suspend fun setColor(context: Context, color: Color) {
        context.datastore.edit { pref ->
            pref[KEY_BG_COLOR] = color.toArgb()
        }
    }

    suspend fun getColor(context: Context): Flow<Color> {
        return context.datastore.data.map {pref ->
            Color(pref[KEY_BG_COLOR] ?: Color.White.toArgb())
        }
    }

}