package com.example.my_intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.my_intent.databinding.ActivityMainBinding
import com.example.my_intent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    private var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> if (result.resultCode == RESULT_OK) {
        val data = result.data
        val address = data?.getStringExtra("address")
        binding.txtAddress.text = "Alamat: ${address}"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var name = intent.getStringExtra("nama")

        with(binding){
            txtName.text = "Welcome ${name}"
            txtAddress.text = "Address: -"

            btnToThirdActivity.setOnClickListener{
                val intenToInputAddress = Intent(this@SecondActivity, ThirdActivity::class.java)
                launcher.launch(intenToInputAddress)
            }
        }
    }
}