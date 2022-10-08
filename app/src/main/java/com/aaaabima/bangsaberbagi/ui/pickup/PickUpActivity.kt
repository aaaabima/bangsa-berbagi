package com.aaaabima.bangsaberbagi.ui.pickup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aaaabima.bangsaberbagi.databinding.ActivityPickUpBinding
import com.aaaabima.bangsaberbagi.ui.MainActivity

class PickUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPickUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Penjemputan Sampah"

        binding.btnConfirm.setOnClickListener {
            val intent = Intent(this@PickUpActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}