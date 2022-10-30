package com.aaaabima.bangsaberbagi.ui.pickup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.aaaabima.bangsaberbagi.databinding.ActivityRegisterBinding
import com.aaaabima.bangsaberbagi.viewmodel.RegisterViewModel
import com.aaaabima.bangsaberbagi.viewmodel.ViewModelFactory

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var factory: ViewModelFactory
    private val model: RegisterViewModel  by viewModels { factory }
    private var nama = ""
    private var email = ""
    private var password = ""
    private var phone = ""
    private var rt = ""
    private var rw = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        factory = ViewModelFactory.getInstance(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Daftar"

        binding.apply {
            registerEdNama.addTextChangedListener { nama = registerEdNama.text.toString() }
            registerEdEmail.addTextChangedListener { email = registerEdEmail.text.toString() }
            registerEdPassword.addTextChangedListener { password = registerEdPassword.text.toString() }
            registerEdNotelp.addTextChangedListener { phone = registerEdNotelp.text.toString() }
            registerEdRt.addTextChangedListener { rt = registerEdRt.text.toString() }
            registerEdRw.addTextChangedListener { rw = registerEdRw.text.toString() }
        }

        implementButton()
    }

    private fun implementButton() {
        binding.btnDaftar.setOnClickListener {
            if(!isValidEmail(email))
                binding.registerEdEmail.error = "Email tidak valid"
            if(nama.isEmpty() || phone.isEmpty() || password.isEmpty() || email.isEmpty() || rt.isEmpty() || rw.isEmpty()) {
                Toast.makeText(
                    this@RegisterActivity,
                    "Isikan semua data dengan benar.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                model.uploadRegisterData(
                    nama,
                    email,
                    password,
                    password,
                    phone,
                    rt,
                    rw
                )



                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        binding.tvMasuk.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}