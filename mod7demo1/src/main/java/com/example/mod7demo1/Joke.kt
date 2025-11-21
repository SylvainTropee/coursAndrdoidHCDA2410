package com.example.mod7demo1

import com.squareup.moshi.Json

data class Joke(
    val id : String,
    @Json(name = "value")
    val content : String,
    @Json(name = "icon_url")
    val iconUrl : String
)
