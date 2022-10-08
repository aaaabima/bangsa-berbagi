package com.aaaabima.bangsaberbagi.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class TokenData(

	@field:SerializedName("expiresIn")
	val expiresIn: Int? = null,

	@field:SerializedName("token")
	val token: String? = null
)

data class FindUser(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("rt")
	val rt: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

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
	val id: String? = null,

	@field:SerializedName("region")
	val region: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class Data(

	@field:SerializedName("findUser")
	val findUser: FindUser? = null,

	@field:SerializedName("tokenData")
	val tokenData: TokenData? = null
)
