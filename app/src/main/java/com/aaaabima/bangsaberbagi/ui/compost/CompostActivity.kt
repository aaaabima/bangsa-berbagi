package com.aaaabima.bangsaberbagi.ui.compost

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aaaabima.bangsaberbagi.databinding.ActivityCompostBinding
import com.aaaabima.bangsaberbagi.ui.MainActivity

class CompostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCompostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCompostBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Penjualan Pupuk"

        binding.btnWhatsapp.setOnClickListener {
            val intent = Intent(this@CompostActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}