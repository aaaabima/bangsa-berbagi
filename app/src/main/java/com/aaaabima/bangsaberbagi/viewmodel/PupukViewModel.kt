package com.aaaabima.bangsaberbagi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaaabima.bangsaberbagi.DataSource
import com.aaaabima.bangsaberbagi.UserSession
import com.aaaabima.bangsaberbagi.response.PupukResponse
import kotlinx.coroutines.launch

class PupukViewModel(private val dataSource: DataSource): ViewModel() {
    val pupuk: LiveData<PupukResponse> = dataSource.pupuk

    fun postOrderData(token: String, name: String, phone_number: String, alamat: String, quantity: String, total_price: String, status: String, status_description: String) {
        viewModelScope.launch {
            dataSource.postPupukOrder(token, name, phone_number, alamat, quantity, total_price, status, status_description)
        }
    }

    fun getUserSession(): LiveData<UserSession> {
        return dataSource.getUserSession()
    }
}