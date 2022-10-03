package com.aaaabima.bangsaberbagi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aaaabima.bangsaberbagi.R
import com.aaaabima.bangsaberbagi.databinding.ActivityCompostBinding

class CompostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCompostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCompostBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Penjualan Pupuk"
    }
}