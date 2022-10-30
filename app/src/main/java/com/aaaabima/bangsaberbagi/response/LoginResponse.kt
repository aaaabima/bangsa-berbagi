package com.aaaabima.bangsaberbagi.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: LoginData? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class User(

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

	@field:SerializedName("profile_picture")
	val profilePicture: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("region")
	val region: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class LoginData(

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("token")
	val token: String? = null
)
