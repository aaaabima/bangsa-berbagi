package com.aaaabima.bangsaberbagi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaaabima.bangsaberbagi.DataSource
import com.aaaabima.bangsaberbagi.UserSession
import com.aaaabima.bangsaberbagi.response.PupukResponse
import com.aaaabima.bangsaberbagi.response.SampahResponse
import kotlinx.coroutines.launch

class PupukViewModel(private val dataSource: DataSource): ViewModel() {
    val pupuk: LiveData<PupukResponse> = dataSource.pupuk

    fun postOrderData(name: String, phone_number: String, alamat: String, quantity: Int, total_price: Int, status: String) {
        viewModelScope.launch {
            dataSource.postPupukOrder(name, phone_number, alamat, quantity, total_price, status)
        }
    }
}