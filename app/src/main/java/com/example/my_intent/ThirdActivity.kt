package com.example.my_intent // Ganti dengan nama package Anda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.my_intent.databinding.ActivityThirdBinding
// Pastikan nama binding sudah sesuai dengan nama file layout (activity_third.xml -> ActivityThirdBinding)


class ThirdActivity : AppCompatActivity() {

    // Nama binding disesuaikan menjadi ActivityThirdBinding
    private lateinit var binding: ActivityThirdBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_NIM = "extra_nim"
        const val EXTRA_HOBBY = "extra_hobby"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME) ?: "Data tidak ditemukan"
        val nim = intent.getStringExtra(EXTRA_NIM) ?: "Data tidak ditemukan"
        val hobby = intent.getStringExtra(EXTRA_HOBBY) ?: "Data tidak ditemukan"

        binding.tvDetailName.text = "Nama: $name"
        binding.tvDetailNim.text = "NIM: $nim"
        binding.tvDetailHobby.text = "Hobi: $hobby"
    }
}