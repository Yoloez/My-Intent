package com.example.my_intent // Ganti dengan nama package Anda

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.my_intent.databinding.ActivitySecondBinding
// Pastikan nama binding sudah sesuai dengan nama file layout (activity_second.xml -> ActivitySecondBinding)

class SecondActivity : AppCompatActivity() {

    // Nama binding disesuaikan menjadi ActivitySecondBinding
    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_NIM = "extra_nim"
        const val EXTRA_HOBBY = "extra_hobby"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val nim = intent.getStringExtra(EXTRA_NIM)
        val hobby = intent.getStringExtra(EXTRA_HOBBY)

        binding.etName.setText(name)
        binding.etNim.setText(nim)
        binding.etHobby.setText(hobby)

        binding.btnSave.setOnClickListener {
            val newName = binding.etName.text.toString().trim()
            val newNim = binding.etNim.text.toString().trim()
            val newHobby = binding.etHobby.text.toString().trim()

            val resultIntent = Intent().apply {
                putExtra(EXTRA_NAME, newName)
                putExtra(EXTRA_NIM, newNim)
                putExtra(EXTRA_HOBBY, newHobby)
            }

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}