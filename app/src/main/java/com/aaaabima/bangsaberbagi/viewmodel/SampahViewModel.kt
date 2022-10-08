package com.aaaabima.bangsaberbagi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaaabima.bangsaberbagi.DataSource
import com.aaaabima.bangsaberbagi.UserSession
import com.aaaabima.bangsaberbagi.response.SampahResponse
import kotlinx.coroutines.launch

class SampahViewModel(private val dataSource: DataSource): ViewModel() {
    val sampah: LiveData<SampahResponse> = dataSource.sampah

    fun postSampahOrder(token: String, name: String, phone_number: String, alamat: String, catatan: String, kategori: String, hari: String, id: String) {
        viewModelScope.launch {
            dataSource.postSampahOrder(token, name, phone_number, alamat, catatan, kategori, hari, id)
        }
    }

    fun getUserSession(): LiveData<UserSession> {
        return dataSource.getUserSession()
    }
}