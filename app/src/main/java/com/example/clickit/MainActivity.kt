package com.example.clickit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.clickit.controller.MainController
import com.example.clickit.model.MainModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainController: MainController
    private lateinit var mainModel: MainModel
    private lateinit var buttonPlayer1: Button
    private lateinit var buttonPlayer2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        buttonPlayer1 = findViewById(R.id.buttonScorePlayer1)
        buttonPlayer2 = findViewById(R.id.buttonScorePlayer2)
        mainModel = MainModel()
        mainController = MainController(mainModel, this)
        buttonPlayer1Clicked()
        buttonPlayer2Clicked()
    }
    private fun buttonPlayer1Clicked() {
        buttonPlayer1.setOnClickListener {
            mainController.updateScorePlayer1()
        }
    }
    private fun buttonPlayer2Clicked() {
        buttonPlayer2.setOnClickListener {
            mainController.updateScorePlayer2()
        }
    }
    fun updateScore(scorePlayer1: Int, scorePlayer2: Int) {
        buttonPlayer1.text = scorePlayer1.toString()
        buttonPlayer2.text = scorePlayer2.toString()
    }
    fun gameFinish(player: String) {
        val winner = "$player ${resources.getString(R.string.Won)}"
        val builder = AlertDialog.Builder(this)
        builder.setTitle(resources.getString(R.string.GameFinish))
            .setMessage(winner).setCancelable(true)
            .setPositiveButton(resources.getString(R.string.OK)) { _, _ ->
                mainController.resetGame()
            }.show()
    }
}