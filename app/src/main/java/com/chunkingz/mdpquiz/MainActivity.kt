package com.chunkingz.mdpquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chunkingz.mdpquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startQuizBtn.setOnClickListener{onStartQuizButtonClick()}
    }

    private fun onStartQuizButtonClick(){
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
}