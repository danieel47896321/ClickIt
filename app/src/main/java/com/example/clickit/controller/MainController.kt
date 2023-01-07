package com.example.clickit.controller

import com.example.clickit.MainActivity
import com.example.clickit.model.MainModel

class MainController(var mainModel: MainModel, var view: MainActivity) {
    private fun getScorePlayer1(): Int { return mainModel.scorePlayer1 }
    private fun getScorePlayer2(): Int { return mainModel.scorePlayer2 }
    fun updateView(){ view.updateScore(getScorePlayer1(), getScorePlayer2()) }
    fun updateScorePlayer1() {
        mainModel.scorePlayer1++
        updateView()
    }
    fun updateScorePlayer2() {
        mainModel.scorePlayer2++
        updateView()
    }
    fun resetGame(){
        mainModel.scorePlayer1 = 0
        mainModel.scorePlayer2 = 0
        updateView()
    }
}