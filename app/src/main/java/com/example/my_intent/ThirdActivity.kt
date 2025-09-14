package com.example.my_intent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.my_intent.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

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

        // Mengambil data dari intent
        val name = intent.getStringExtra(EXTRA_NAME) ?: "Data tidak ditemukan"
        val nim = intent.getStringExtra(EXTRA_NIM) ?: "Data tidak ditemukan"
        val hobby = intent.getStringExtra(EXTRA_HOBBY) ?: "Data tidak ditemukan"

        // Menampilkan data di TextView
        binding.tvDetailName.text = "Nama: $name"
        binding.tvDetailNim.text = "NIM: $nim"
        binding.tvDetailHobby.text = "Hobi: $hobby"

        // --- KODE TAMBAHAN DIMULAI DI SINI ---

        // Menambahkan listener klik pada tombol kembali
        binding.btnBackToMain.setOnClickListener {
            // Perintah untuk menutup Activity saat ini (ThirdActivity)
            // dan kembali ke Activity sebelumnya di tumpukan (MainActivity)
            finish()
        }

        // --- KODE TAMBAHAN SELESAI ---
    }
}