package com.example.clickit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.clickit.controller.MainController

class MainActivity : AppCompatActivity() {
    private lateinit var mainController: MainController
    private lateinit var buttonPlayer1: Button
    private lateinit var buttonPlayer2: Button
    private lateinit var buttonResetGame: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        mainController = MainController(this)
        buttonPlayer1 = findViewById(R.id.buttonScorePlayer1)
        buttonPlayer2 = findViewById(R.id.buttonScorePlayer2)
        buttonResetGame = findViewById(R.id.buttonResetGame)
        mainController.updateView()
        setButtons()
    }
    fun mainWhenCase(id: String){
        when(id){
            "updateScore" -> { updateScore(mainController.getScorePlayer1(), mainController.getScorePlayer2()) }
        }
    }
    private fun setButtons() {
        buttonPlayer1.setOnClickListener { mainController.updateScorePlayer1() }
        buttonPlayer2.setOnClickListener { mainController.updateScorePlayer2() }
        buttonResetGame.setOnClickListener { mainController.resetGame() }
    }
    private fun updateScore(scorePlayer1: Int, scorePlayer2: Int) {
        buttonPlayer1.text = scorePlayer1.toString()
        buttonPlayer2.text = scorePlayer2.toString()
    }
}