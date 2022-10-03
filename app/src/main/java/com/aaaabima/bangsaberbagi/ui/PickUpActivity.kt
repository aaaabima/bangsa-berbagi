package com.aaaabima.bangsaberbagi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aaaabima.bangsaberbagi.R
import com.aaaabima.bangsaberbagi.databinding.ActivityPickUpBinding

class PickUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPickUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Penjemputan Sampah"
    }
}