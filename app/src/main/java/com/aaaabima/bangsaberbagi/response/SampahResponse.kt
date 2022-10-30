package com.aaaabima.bangsaberbagi.response

import com.google.gson.annotations.SerializedName

data class SampahResponse(

	@field:SerializedName("data")
	val data: SampahData? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class SampahData(

	@field:SerializedName("address_notes")
	val addressNotes: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("schedule_pickup")
	val schedulePickup: String? = null,

	@field:SerializedName("sampah_category")
	val sampahCategory: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("phone_number")
	val phoneNumber: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
