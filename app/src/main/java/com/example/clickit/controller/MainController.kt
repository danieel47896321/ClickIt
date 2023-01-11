package com.example.clickit.controller

import androidx.lifecycle.ViewModelProvider
import com.example.clickit.MainActivity
import com.example.clickit.model.MainModel

class MainController(var view: MainActivity) {
    private var mainModel = ViewModelProvider(view)[MainModel::class.java]
    fun getScorePlayer1(): Int { return mainModel.scorePlayer1 }
    fun getScorePlayer2(): Int { return mainModel.scorePlayer2 }
    fun updateView(){ view.mainWhenCase(mainModel.updateID) }
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