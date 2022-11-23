package com.aaaabima.bangsaberbagi.ui.pickup

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.aaaabima.bangsaberbagi.databinding.ActivityPickUpBinding
import com.aaaabima.bangsaberbagi.viewmodel.SampahViewModel
import com.aaaabima.bangsaberbagi.viewmodel.ViewModelFactory

class PickUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPickUpBinding
    private lateinit var factory: ViewModelFactory
    private val model: SampahViewModel by viewModels { factory }
    private var token = ""
    private var userId = ""
    private var nama = ""
    private var phone = ""
    private var address = ""
    private var note = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        factory = ViewModelFactory.getInstance(this)

        supportActionBar?.title = "Penjemputan Sampah"

        binding.apply {
            pickupEdNama.addTextChangedListener { nama = pickupEdNama.text.toString() }
            pickupEdNotelp.addTextChangedListener { phone = pickupEdNotelp.text.toString() }
            pickupEdAlamat.addTextChangedListener { address = pickupEdAlamat.text.toString() }
            pickupEdNote.addTextChangedListener { note = pickupEdNote.text.toString() }
        }

        isLogin()
        implementButton()
    }

    private fun isLogin() {
        model.getUserSession().observe(this@PickUpActivity) {
            token = it.token
            if (!it.isLoggedIn) {
                val intent = Intent(this@PickUpActivity, LoginActivity::class.java)
                startActivity(intent)
            } else {
                userId = it.id
            }
        }
    }

    private fun implementButton() {
        val category = findViewById<RadioButton>(binding.rgJenisSampah.checkedRadioButtonId).text.toString()
        val hari = findViewById<RadioButton>(binding.rgHari.checkedRadioButtonId).text.toString()

        binding.btnConfirm.setOnClickListener {
            if(nama.isEmpty() || phone.isEmpty() || address.isEmpty())
                Toast.makeText(this@PickUpActivity,"Isikan semua data dengan benar.", Toast.LENGTH_SHORT).show()
            else{
                model.postSampahOrder(
                    token,
                    nama,
                    phone,
                    address,
                    note,
                    category,
                    hari,
                    userId
                )

                model.sampah.observe(this@PickUpActivity) { response ->
                    if (response.message == "Data has been inserted successfully")
                        Toast.makeText(this@PickUpActivity, "Data telah berhasil dimasukkan.", Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this@PickUpActivity, response.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}