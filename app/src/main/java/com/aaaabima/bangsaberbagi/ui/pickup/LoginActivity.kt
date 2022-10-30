package com.aaaabima.bangsaberbagi.ui.pickup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.aaaabima.bangsaberbagi.UserSession
import com.aaaabima.bangsaberbagi.databinding.ActivityLoginBinding
import com.aaaabima.bangsaberbagi.viewmodel.LoginViewModel
import com.aaaabima.bangsaberbagi.viewmodel.ViewModelFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var factory: ViewModelFactory
    private val model: LoginViewModel by viewModels { factory }
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        factory = ViewModelFactory.getInstance(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Masuk"

        binding.apply {
            loginEdEmail.addTextChangedListener { email = loginEdEmail.text.toString() }
            loginEdPassword.addTextChangedListener { email = loginEdPassword.text.toString() }
        }

        implementButton()
    }

    private fun implementButton() {
        binding.btnMasuk.setOnClickListener {
            if(email.isEmpty())
                binding.loginEdEmail.error = "Bagian ini harus diisi"
            if(password.isEmpty())
                binding.loginEdPassword.error = "Bagian ini harus diisi"
            if(!isValidEmail(email))
                binding.loginEdEmail.error = "Email tidak valid"
            binding.apply {
                model.uploadLoginData(
                    email,
                    password
                )
            }
            model.login.observe(this@LoginActivity) { response ->
                saveUserSession(
                    UserSession(
                        response.data!!.user!!.id.toString(),
                        "Bearer " + (response.data.token),
                        true
                    )
                )
            }
            model.userLogin()
            val intent = Intent(this@LoginActivity, PickUpActivity::class.java)
            startActivity(intent)
        }
        binding.tvDaftar.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun saveUserSession(session: UserSession){
        model.saveUserSession(session)
    }
}