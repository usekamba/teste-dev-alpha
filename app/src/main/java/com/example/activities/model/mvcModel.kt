package com.example.activities.model

import com.google.gson.annotations.SerializedName

data class activities
    (
    val id:String? =null,
    val intent :String? =null,
    val amount :String? =null,
    val subtotal :String?=null,
    val fee :String?=null,

    @SerializedName("from")
    val from: from,

    @SerializedName("to")
    val to: to ,

    val description :String ?=null,
    val transaction_type :String? =null,
    val status : String?=null,
    val created_at :String ,
    val reference_checkout :String ? =null,
    val reference_recharge :String ? =null,
    val phone_number: String? =null,
    val  mobile_recharge_card_id : String ? =null,
    val transaction_id :String ? =null,
    val recharge_code :String ? =null,
    val recharge_price :String ? =null,
    val amount_of_utts :String ? = null,
    val validity_days :String ? =null,
    val mobile_operator_name :String? =null,
    val  mobile_operator_type :String ?=null,
    val amount_paid :String ? =null,

    val payment_method: payment_method ?=null,

    @SerializedName("company_bank_account")
    val company_bankAccount: company_bank_account? =null,

    val receipt_image: String ?=null
)

data class from(

    val id: String? =null,
    val firstname: String?=null,
    val lastname: String?=null,
    val phone_number: String?=null,
    val email: String?=null,
    val profile_photo: String?=null
)

data class to(

    var id: String? =null,
    var firstname: String?=null,
    var lastname: String?=null,
    var phone_number: String?=null,
    var email: String?=null,
    var profile_photo: String?=null
)

data class payment_method(
    val id :String?=null,
    val name :String ?=null,
    val description: String? =null
)

data class  company_bank_account(
    val id: String? =null,
    val number :String?=null,
    val type_of:String?=null,
    val holder :String? =null,
    val bank: bank ?=null
)

data class bank(
    val id: String? =null,
    val name :String ?=null,
    val description: String? =null
)




