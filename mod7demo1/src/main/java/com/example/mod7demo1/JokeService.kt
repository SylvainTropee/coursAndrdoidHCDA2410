package com.example.mod7demo1

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface JokeService {

    @GET("random")
    suspend fun getRandomJoke(): Joke

    @GET("joke/{id}")
    suspend fun getJokeById(@Path("id") id: Long): Joke?

    @POST("joke")
    suspend fun addJoke(@Body joke: Joke)
}

object CallJokeApi {

    val BASE_URL = "https://api.chucknorris.io/jokes/"


    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val retrofitService: JokeService by lazy { retrofit.create(JokeService::class.java) }


}