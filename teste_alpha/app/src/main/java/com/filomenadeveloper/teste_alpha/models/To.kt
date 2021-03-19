package com.filomenadeveloper.teste_alpha.models

import com.google.gson.annotations.SerializedName

data class To(@SerializedName("id") val id:String,
              @SerializedName("firstname") val firstname:String,
              @SerializedName("lastname") val lastname:String,
              @SerializedName("phone_number") val phone_number:String,
              @SerializedName("email") val email:String,
              @SerializedName("profile_photo") val profile_photo:String) {
}