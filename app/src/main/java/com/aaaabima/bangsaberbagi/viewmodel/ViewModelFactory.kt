package com.aaaabima.bangsaberbagi.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aaaabima.bangsaberbagi.DataSource
import com.aaaabima.bangsaberbagi.Injection

class ViewModelFactory(private val dataSource: DataSource): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
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

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory {
            return instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }.also { instance = it }
        }
    }
}