package com.aaaabima.bangsaberbagi.ui.compost

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aaaabima.bangsaberbagi.databinding.ActivityCompostBinding
import com.aaaabima.bangsaberbagi.ui.MainActivity
import com.aaaabima.bangsaberbagi.viewmodel.LoginViewModel
import com.aaaabima.bangsaberbagi.viewmodel.PupukViewModel
import com.aaaabima.bangsaberbagi.viewmodel.ViewModelFactory

class CompostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCompostBinding
    private lateinit var factory: ViewModelFactory
    private val model: PupukViewModel by viewModels { factory }
    private var quantity = 0
    private var totalPrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCompostBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        factory = ViewModelFactory.getInstance(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Penjualan Pupuk"

        implementButton()
    }

    private fun implementButton() {
        binding.btnWhatsapp1.setOnClickListener {
            postOrder(1)
        }
        binding.btnWhatsapp2.setOnClickListener {
            postOrder(2)
        }
    }

    private fun postOrder(num: Int) {
        val nama = binding.addEdNama.text.toString().trim()
        val phone = binding.addEdNotelp.text.toString().trim()
        val address = binding.addEdAlamat.text.toString().trim()
        selectedButton()
        if(nama.isEmpty() || phone.isEmpty() || address.isEmpty())
            Toast.makeText(this@CompostActivity,"Isikan semua data dengan benar.", Toast.LENGTH_SHORT).show()
        else {
            model.postOrderData(
                nama,
                phone,
                address,
                quantity,
                totalPrice,
                "PESANAN_BARU"
            )

            model.pupuk.observe(this) {response ->
                if(response.message == "Data has been inserted successfully"){
                    Toast.makeText(this@CompostActivity, "Data telah berhasil dimasukkan.", Toast.LENGTH_SHORT).show()
                    when(num) {
                        1->sendToWhatsappFirst()
                        2->sendToWhatsappSecond()
                    }
                }
            }
        }
    }

    private fun sendToWhatsappFirst() {
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

    private fun sendToWhatsappSecond() {
        val contact = "+6289648220154"
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

    private fun selectedButton() {
        when (findViewById<RadioButton>(binding.rgJenisCompost.checkedRadioButtonId)) {
            binding.compostA -> {
                quantity = 500
                totalPrice = 5000
            }
            binding.compostB -> {
                quantity = 1000
                totalPrice = 10000
            }
            binding.compostC -> {
                quantity = 1500
                totalPrice = 15000
            }
            binding.compostD -> {
                quantity = 2000
                totalPrice = 20000
            }
        }
    }
}