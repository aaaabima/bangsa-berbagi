package com.aaaabima.bangsaberbagi.ui.informasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aaaabima.bangsaberbagi.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Jenis-Jenis Sampah"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}