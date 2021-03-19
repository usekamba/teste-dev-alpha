package com.filomenadeveloper.teste_alpha.models

import com.google.gson.annotations.SerializedName

data class Bank(@SerializedName("id") val id:String,
                @SerializedName("name") val name:String,
                @SerializedName("description") val description:String,
                @SerializedName("app_link") val app_link: String? = null,
                @SerializedName("logo_url") val logo_url:String? = null) {

}
