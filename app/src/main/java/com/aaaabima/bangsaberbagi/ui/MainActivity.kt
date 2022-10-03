package com.aaaabima.bangsaberbagi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aaaabima.bangsaberbagi.databinding.ActivityMainBinding
import com.aaaabima.bangsaberbagi.ui.informasi.InformationActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Bangsa Berbagi"

        applyButton()
    }

    private fun applyButton() {
        binding.buttonInformasi.setOnClickListener {
            val intent = Intent(this@MainActivity, InformationActivity::class.java)
            startActivity(intent)
        }
        binding.buttonPenjemputan.setOnClickListener {
            val intent = Intent(this@MainActivity, PickUpActivity::class.java)
            startActivity(intent)
        }
        binding.buttonPenjualan.setOnClickListener {
            val intent = Intent(this@MainActivity, CompostActivity::class.java)
            startActivity(intent)
        }
    }
}