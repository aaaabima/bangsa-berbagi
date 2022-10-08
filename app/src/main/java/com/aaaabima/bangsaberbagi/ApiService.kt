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
        @Field("phone_number") phone_number: String,
        @Field("rt") rt: String,
        @Field("rw") rw: String,
        @Field("region") alamat: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun uploadLoginData(
        @Field("email") name: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @POST("logout")
    fun logout(
        @Header("Authorization") token: String,
    )

    @FormUrlEncoded
    @POST("v2/pupuk")
    fun postPupukOrder(
        @Header("Authorization") token: String,
        @Field("name") name: String,
        @Field("phone_number") phone_number: String,
        @Field("address") alamat: String,
        @Field("quantity") quantity: String,
        @Field("total_price") total_price: String,
        @Field("status") status: String,
        @Field("status_description") status_description: String,
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

    @GET("users/{id}")
    fun getId(
        @Header("Authorization") token: String,
        @Path("id") id: String
    )
}