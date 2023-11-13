package com.chunkingz.mdpquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.chunkingz.mdpquiz.databinding.ActivityQuizBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener{onSubmitButtonClick()}
        binding.resetBtn.setOnClickListener{onResetButtonClick()}
    }

    private fun onSubmitButtonClick() {
        val score = calculateScore()

        val dateFormat = SimpleDateFormat("dd MMMM yyyy 'at' hh:mm a", Locale.getDefault())
        val currentDateAndTime: String = dateFormat.format(Date())

        val message = "Congratulations! You submitted on $currentDateAndTime, and you achieved ${score}%"

        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        alertDialogBuilder.create().show()
    }

    private fun onResetButtonClick() {
        binding.radioGroup.clearCheck()
        binding.checkBox1.isChecked = false
        binding.checkBox2.isChecked = false
        binding.checkBox3.isChecked = false
        binding.checkBox4.isChecked = false
    }

    private fun calculateScore(): Int {
        var score = 0

        // 1st question
        val selectedRadioButtonId = binding.radioGroup.checkedRadioButtonId
        if (selectedRadioButtonId == binding.radioBtn2.id) {
            score += 50
        }

        // 2nd question
        if (binding.checkBox1.isChecked && binding.checkBox2.isChecked && !binding.checkBox3.isChecked && binding.checkBox4.isChecked) {
            score += 50
        }

        return score
    }
}