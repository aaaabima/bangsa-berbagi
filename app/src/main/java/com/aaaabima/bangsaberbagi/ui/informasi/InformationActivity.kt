package com.aaaabima.bangsaberbagi.ui.informasi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aaaabima.bangsaberbagi.databinding.ActivityInformationBinding
import com.aaaabima.bangsaberbagi.ui.informasi.ContentActivity.Companion.EXTRA_FRAGMENT

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
        val intent = Intent(this@InformationActivity, ContentActivity::class.java)
        binding.btnJenis.setOnClickListener {
            intent.putExtra(EXTRA_FRAGMENT,"Jenis Jenis Sampah")
            startActivity(intent)
        }
        binding.btnManfaat.setOnClickListener {
            intent.putExtra(EXTRA_FRAGMENT,"Manfaat Sampah")
            startActivity(intent)
        }
        binding.btnPengolahan.setOnClickListener {
            intent.putExtra(EXTRA_FRAGMENT,"Pengolahan Sampah")
            startActivity(intent)
        }
        binding.btnPemilahan.setOnClickListener {
            intent.putExtra(EXTRA_FRAGMENT,"Pemilahan Sampah")
            startActivity(intent)
        }
        binding.btnLingkungan.setOnClickListener {
            intent.putExtra(EXTRA_FRAGMENT, "Aspek Lingkungan")
            startActivity(intent)
        }
        binding.btnKesehatan.setOnClickListener {
            intent.putExtra(EXTRA_FRAGMENT, "Aspek Kesehatan")
            startActivity(intent)
        }
        binding.btnEkonomi.setOnClickListener {
            intent.putExtra(EXTRA_FRAGMENT, "Aspek Ekonomi")
            startActivity(intent)
        }
        binding.btnKegunaanPupuk.setOnClickListener {
            intent.putExtra(EXTRA_FRAGMENT, "Kegunaan Pupuk")
            startActivity(intent)
        }
        binding.btnKreativitasSampah.setOnClickListener {
            intent.putExtra(EXTRA_FRAGMENT, "Kreativitas Sampah")
            startActivity(intent)
        }
        binding.btnMembuatPupuk.setOnClickListener {
            intent.putExtra(EXTRA_FRAGMENT, "Membuat Pupuk")
            startActivity(intent)
        }
        binding.btnNilaiEkonomi.setOnClickListener {
            intent.putExtra(EXTRA_FRAGMENT, "Nilai Ekonomi Sampah")
            startActivity(intent)
        }
    }
}