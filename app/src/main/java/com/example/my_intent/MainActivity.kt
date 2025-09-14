// 1. UBAH NAMA PACKAGE INI
package com.example.my_intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

// 2. PERBAIKI IMPORT INI
import com.example.my_intent.databinding.ActivityMainBinding


// MainActivity tidak perlu diimpor
// import com.example.MainActivity.SecondActivity <-- HAPUS ATAU GANTI BARIS INI

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Data default mahasiswa
    private var currentName = "Hanan Fijananto"
    private var currentNim = "24/538946/SV/24555"
    private var currentHobby = "Membaca Buku"

    // Menangani hasil dari SecondActivity
    private val editProfileLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                // Ambil data baru dari intent
                val newName = data?.getStringExtra(SecondActivity.EXTRA_NAME)
                val newNim = data?.getStringExtra(SecondActivity.EXTRA_NIM)
                val newHobby = data?.getStringExtra(SecondActivity.EXTRA_HOBBY)

                // Perbarui data
                if (!newName.isNullOrEmpty()) currentName = newName
                if (!newNim.isNullOrEmpty()) currentNim = newNim
                if (!newHobby.isNullOrEmpty()) currentHobby = newHobby

                // Tampilkan data yang sudah diperbarui
                updateProfileUI()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateProfileUI()

        // Tombol untuk pindah ke halaman ubah profil (SecondActivity)
        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(SecondActivity.EXTRA_NAME, currentName)
                putExtra(SecondActivity.EXTRA_NIM, currentNim)
                putExtra(SecondActivity.EXTRA_HOBBY, currentHobby)
            }
            editProfileLauncher.launch(intent)
        }

        // Tombol untuk pindah ke halaman detail (ThirdActivity)
        binding.btnDetail.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java).apply {
                putExtra(ThirdActivity.EXTRA_NAME, currentName)
                putExtra(ThirdActivity.EXTRA_NIM, currentNim)
                putExtra(ThirdActivity.EXTRA_HOBBY, currentHobby)
            }
            startActivity(intent)
        }
    }

    private fun updateProfileUI() {
        binding.tvName.text = "Nama: $currentName"
        binding.tvNim.text = "NIM: $currentNim"
    }
}