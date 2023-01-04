package com.example.clickit.controller

import com.example.clickit.MainActivity
import com.example.clickit.R
import com.example.clickit.model.MainModel

class MainController(var mainModel: MainModel, var view: MainActivity) {
    private fun getScorePlayer1(): Int { return mainModel.scorePlayer1 }
    private fun getScorePlayer2(): Int { return mainModel.scorePlayer2 }
    private fun updateView(){ view.updateScore(getScorePlayer1(), getScorePlayer2()) }
    fun updateScorePlayer1() {
        if (mainModel.scorePlayer1 < 30) {
            mainModel.scorePlayer1++
            updateView()
        }
        else
            view.gameFinish(view.resources.getString(R.string.Player1))
    }
    fun updateScorePlayer2() {
        if (mainModel.scorePlayer2 < 30) {
            mainModel.scorePlayer2++
            updateView()
        }
        else
            view.gameFinish(view.resources.getString(R.string.Player2))
    }
    fun resetGame(){
        mainModel.scorePlayer1 = 0
        mainModel.scorePlayer2 = 0
        updateView()
    }
}