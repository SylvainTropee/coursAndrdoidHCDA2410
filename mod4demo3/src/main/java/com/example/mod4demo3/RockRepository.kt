package com.example.mod4demo3

class RockRepository {

    private val rockBand = listOf("Gojira", "ACDC", "Nirvana", "Muse", "The Beatles", "The Rolling Stones", "Led Zeppelin")

    fun getAllRockBand(): List<String> {
        return rockBand
    }

}