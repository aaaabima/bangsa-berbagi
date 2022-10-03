package com.aaaabima.bangsaberbagi.ui.informasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.aaaabima.bangsaberbagi.R
import com.aaaabima.bangsaberbagi.databinding.ActivityInformationBinding
import com.aaaabima.bangsaberbagi.ui.informasi.pengenalan.JenisSampahFragment

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Informasi & Edukasi Sampah"

        applyButton()
    }

    private fun applyButton() {
        binding.btnJenis.setOnClickListener {
            val mFragment = JenisSampahFragment()
            val mFragmentManager = supportFragmentManager
            val fragment = mFragmentManager.findFragmentByTag(JenisSampahFragment::class.java.simpleName)

            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_layout,mFragment,JenisSampahFragment::class.java.simpleName)
                .commit()
        }
    }
}