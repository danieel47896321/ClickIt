package com.example.clickit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.clickit.controller.MainController
import com.example.clickit.model.MainModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainController: MainController
    private lateinit var mainModel: MainModel
    private lateinit var buttonPlayer1: Button
    private lateinit var buttonPlayer2: Button
    private lateinit var buttonResetGame: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        mainModel = ViewModelProvider(this)[MainModel::class.java]
        buttonPlayer1 = findViewById(R.id.buttonScorePlayer1)
        buttonPlayer2 = findViewById(R.id.buttonScorePlayer2)
        buttonResetGame = findViewById(R.id.buttonResetGame)
        mainController = MainController(mainModel, this)
        mainController.updateView()
        setButtonPlayer1()
        setButtonPlayer2()
        setButtonResetGame()
    }
    private fun setButtonPlayer1() {
        buttonPlayer1.setOnClickListener {
            mainController.updateScorePlayer1()
        }
    }
    private fun setButtonPlayer2() {
        buttonPlayer2.setOnClickListener {
            mainController.updateScorePlayer2()
        }
    }
    private fun setButtonResetGame() {
        buttonResetGame.setOnClickListener {
            mainController.resetGame()
        }
    }
    fun updateScore(scorePlayer1: Int, scorePlayer2: Int) {
        buttonPlayer1.text = scorePlayer1.toString()
        buttonPlayer2.text = scorePlayer2.toString()
    }
}