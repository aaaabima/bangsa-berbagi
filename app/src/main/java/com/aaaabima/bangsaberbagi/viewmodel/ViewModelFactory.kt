package com.aaaabima.bangsaberbagi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aaaabima.bangsaberbagi.DataSource

class ViewModelFactory(private val dataSource: DataSource): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(dataSource) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(dataSource) as T
            }
            modelClass.isAssignableFrom(SampahViewModel::class.java) -> {
                SampahViewModel(dataSource) as T
            }
            modelClass.isAssignableFrom(PupukViewModel::class.java) -> {
                PupukViewModel(dataSource) as T
            }
            else -> throw IllegalArgumentException("Unknown Model class: " + modelClass.name)
        }
    }
}