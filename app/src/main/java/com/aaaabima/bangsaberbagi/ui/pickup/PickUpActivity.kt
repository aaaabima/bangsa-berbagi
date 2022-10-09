package com.aaaabima.bangsaberbagi.ui.pickup

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.RadioButton
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
            sendToWhatsapp()
        }
    }

    private fun sendToWhatsapp() {
        val contact = "+6282316720907"
        val name = binding.pickupEdNama.text.toString()
        val notelp = binding.pickupEdNotelp.text.toString()
        val alamat = binding.pickupEdAlamat.text.toString()
        val catatan = binding.pickupEdNote.text.toString()
        val sampah = findViewById<RadioButton>(binding.rgJenisSampah.checkedRadioButtonId).text.toString()
        val hari = findViewById<RadioButton>(binding.rgHari.checkedRadioButtonId).text.toString()
        val formattedText = "Nama: $name\nNomor Telepon: $notelp\nAlamat: $alamat\nCatatan: $catatan\nKategori Sampah: $sampah\nHari: $hari"

        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$contact&text=$formattedText")
        startActivity(intent)
    }
}