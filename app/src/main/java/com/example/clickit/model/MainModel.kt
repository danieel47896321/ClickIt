package com.example.clickit.model

import java.util.*

class MainModel : Observable() {
    private var scorePlayer1 = 0
    private var scorePlayer2 = 0
    fun getScorePlayer1(): Int { return scorePlayer1 }
    fun getScorePlayer2(): Int { return scorePlayer2 }
}