package com.filomenadeveloper.teste_alpha.models

import com.google.gson.annotations.SerializedName

 data class Company_Bank_Account(@SerializedName("id") val id:String,
                                 @SerializedName("iban") val iban:String,
                                 @SerializedName("number") val number:String,
                                 @SerializedName("type_of") val type_of:String,
                                 @SerializedName("holder") val holder:String,
                                 @SerializedName("bank") val bank: Bank) {
}