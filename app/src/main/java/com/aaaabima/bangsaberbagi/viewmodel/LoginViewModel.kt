package com.aaaabima.bangsaberbagi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaaabima.bangsaberbagi.DataSource
import com.aaaabima.bangsaberbagi.UserSession
import com.aaaabima.bangsaberbagi.response.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel(private val dataSource: DataSource): ViewModel()  {
    val login: LiveData<LoginResponse> = dataSource.login

    fun uploadLoginData(email: String, password: String) {
        viewModelScope.launch {
            dataSource.uploadLoginData(email, password)
        }
    }

    fun saveUserSession(session: UserSession) {
        viewModelScope.launch {
            dataSource.saveSession(session)
        }
    }

    fun userLogin() {
        viewModelScope.launch {
            dataSource.userLogin()
        }
    }
}