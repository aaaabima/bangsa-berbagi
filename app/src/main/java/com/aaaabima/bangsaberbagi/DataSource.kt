package com.aaaabima.bangsaberbagi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.aaaabima.bangsaberbagi.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataSource private constructor(private val pref: UserPreferences) {
    private val _register = MutableLiveData<RegisterResponse>()
    val register: LiveData<RegisterResponse> = _register

    private val _login = MutableLiveData<LoginResponse>()
    val login: LiveData<LoginResponse> = _login

    private val _sampah = MutableLiveData<SampahResponse>()
    val sampah: LiveData<SampahResponse> = _sampah

    private val _pupuk = MutableLiveData<PupukResponse>()
    val pupuk: LiveData<PupukResponse> = _pupuk

    fun uploadRegisterData(name: String, email: String, password: String, notelp: String, rt: String, rw: String, alamat: String) {
        val client = ApiConfig.getApiService().uploadRegisterData(name, email, password, notelp, rt, rw, alamat)
        client.enqueue(object: Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    Log.d(TAG, "RegisterResponseSuccess: ${response.message()}")
                    _register.value = responseBody!!
                } else {
                    Log.e(TAG, "RegisterResponse: ${response.message()}", )
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.e(TAG, "RegisterFailure: ${t.message}", )
            }
        })
    }

    fun uploadLoginData(email: String, password: String) {
        val client = ApiConfig.getApiService().uploadLoginData(email, password)
        client.enqueue(object: Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    Log.d(TAG, "LoginResponseSuccess: ${response.message()}")
                    _login.value = responseBody!!
                } else {
                    Log.e(TAG, "LoginResponse: ${response.message()}", )
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e(TAG, "LoginFailure: ${t.message}", )
            }
        })
    }

    fun postPupukOrder(name: String, phone_number: String, alamat: String, quantity: Int, total_price: Int, status: String) {
        val client = ApiConfig.getApiService().postPupukOrder(name, phone_number, alamat, quantity, total_price, status)
        client.enqueue(object: Callback<PupukResponse> {
            override fun onResponse(
                call: Call<PupukResponse>,
                response: Response<PupukResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    Log.d(TAG, "PupukResponseSuccess: ${response.message()}")
                    _pupuk.value = responseBody!!
                } else {
                    Log.e(TAG, "PupukResponse: ${response.message()}", )
                }
            }

            override fun onFailure(call: Call<PupukResponse>, t: Throwable) {
                Log.e(TAG, "PupukFailure: ${t.message}", )
            }
        })
    }

    fun postSampahOrder(token: String, name: String, phone_number: String, alamat: String, catatan: String, kategori: String, hari: String, id: String) {
        val client = ApiConfig.getApiService().postSampahOrder(token, name, phone_number, alamat, catatan, kategori, hari, id)
        client.enqueue(object: Callback<SampahResponse> {
            override fun onResponse(
                call: Call<SampahResponse>,
                response: Response<SampahResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful) {
                    Log.d(TAG, "SampahResponseSuccess: ${response.message()}")
                    _sampah.value = responseBody!!
                } else {
                    Log.e(TAG, "SampahResponse: ${response.message()}", )
                }
            }

            override fun onFailure(call: Call<SampahResponse>, t: Throwable) {
                Log.e(TAG, "SampahFailure: ${t.message}", )
            }
        })
    }

    fun getUserSession(): LiveData<UserSession> {
        return pref.getUserSession().asLiveData()
    }

    suspend fun saveSession(session: UserSession) {
        pref.saveUserSession(session)
    }

    suspend fun userLogin() {
        pref.login()
    }

    companion object {
        const val TAG = "DataSource"

        @Volatile
        private var instance: DataSource? = null
        fun getInstance(
            preferences: UserPreferences
        ): DataSource =
            instance ?: synchronized(this) {
                instance ?: DataSource(preferences)
            }.also { instance = it }
    }
}