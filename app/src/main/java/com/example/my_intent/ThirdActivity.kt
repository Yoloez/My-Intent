package com.example.my_intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.my_intent.databinding.ActivityMainBinding
import com.example.my_intent.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityThirdBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding){
            btnBackToSecondActivity.setOnClickListener {
                val resultIntent = Intent()

                resultIntent.putExtra("address", edtAddress.text.toString())

                setResult(RESULT_OK, resultIntent)

                finish()
            }
        }
    }
}