package com.aaaabima.bangsaberbagi.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("data user")
	val dataUser: DataUser? = null
)

data class DataUser(

	@field:SerializedName("rt")
	val rt: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("rw")
	val rw: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("phone_number")
	val phoneNumber: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)
