package com.aaaabima.bangsaberbagi.ui.compost

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.RadioButton
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
            sendToWhatsapp()
        }
        binding.ivWhatsapp.setOnClickListener {
            sendToWhatsapp()
        }
    }

    private fun sendToWhatsapp() {
        val contact = "+6282316720907"
        val name = binding.addEdNama.text.toString()
        val notelp = binding.addEdNotelp.text.toString()
        val alamat = binding.addEdAlamat.text.toString()
        val pupuk = findViewById<RadioButton>(binding.rgJenisCompost.checkedRadioButtonId).text.toString()
        val formattedText = "Nama: $name\nNomor Telepon: $notelp\nAlamat: $alamat\nPesanan: $pupuk"

        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$contact&text=$formattedText")
        startActivity(intent)
    }
}