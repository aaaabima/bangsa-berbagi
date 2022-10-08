package com.aaaabima.bangsaberbagi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaaabima.bangsaberbagi.DataSource
import com.aaaabima.bangsaberbagi.response.RegisterResponse
import kotlinx.coroutines.launch

class RegisterViewModel(private val dataSource: DataSource): ViewModel() {
    val register: LiveData<RegisterResponse> = dataSource.register

    fun uploadRegisterData(name: String, email: String, password: String, notelp: String, rt: String, rw: String, alamat: String) {
        viewModelScope.launch {
            dataSource.uploadRegisterData(name, email, password, notelp, rt, rw, alamat)
        }
    }
}