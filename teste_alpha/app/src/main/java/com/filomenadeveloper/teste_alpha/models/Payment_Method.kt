package com.filomenadeveloper.teste_alpha.models

import com.google.gson.annotations.SerializedName

data class Payment_Method(@SerializedName("id") val id:String,
                          @SerializedName("name") val name:String,
                          @SerializedName("description") val description:String) {
}