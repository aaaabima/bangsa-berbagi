package com.aaaabima.bangsaberbagi

import com.aaaabima.bangsaberbagi.response.LoginResponse
import com.aaaabima.bangsaberbagi.response.PupukResponse
import com.aaaabima.bangsaberbagi.response.RegisterResponse
import com.aaaabima.bangsaberbagi.response.SampahResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun uploadRegisterData(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("c_password") c_password: String,
        @Field("phone_number") phone_number: String,
        @Field("rt") rt: String,
        @Field("rw") rw: String,
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun uploadLoginData(
        @Field("email") name: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("v2/pupuk")
    fun postPupukOrder(
        @Field("name") name: String,
        @Field("phone_number") phone_number: String,
        @Field("address") alamat: String,
        @Field("quantity") quantity: Int,
        @Field("total_price") total_price: Int,
        @Field("status") status: String,
    ): Call<PupukResponse>

    @FormUrlEncoded
    @POST("v2/sampah")
    fun postSampahOrder(
        @Header("Authorization") token: String,
        @Field("name") name: String,
        @Field("phone_number") phone_number: String,
        @Field("address") alamat: String,
        @Field("address_notes") notes: String,
        @Field("sampah_category") category: String,
        @Field("schedule_pickup") day: String,
        @Field("user_id") id: String,
    ): Call<SampahResponse>
}