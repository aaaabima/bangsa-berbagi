package com.aaaabima.bangsaberbagi.response

import com.google.gson.annotations.SerializedName

data class PupukResponse(

	@field:SerializedName("data")
	val data: PupukData? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class PupukData(

	@field:SerializedName("status_description")
	val statusDescription: Any? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("quantity")
	val quantity: String? = null,

	@field:SerializedName("total_price")
	val totalPrice: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("phone_number")
	val phoneNumber: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("status")
	val status: String? = null
)
