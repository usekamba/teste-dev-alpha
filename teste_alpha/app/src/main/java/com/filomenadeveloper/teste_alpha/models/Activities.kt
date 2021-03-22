package com.filomenadeveloper.teste_alpha.models

import com.google.gson.annotations.SerializedName

data class Activities(
        @SerializedName("id") val id:String,
        @SerializedName("intent") val intent:String,
        @SerializedName("amount") val amount:Float,
        @SerializedName("subtotal") val subtotal:Float,
        @SerializedName("fee") val fee:Float,
        @SerializedName("bank_account") val bank_account: Bank_Account,
        @SerializedName("from") val from: From,
        @SerializedName("to") val to: To,
        @SerializedName("payment_method") val payment_method: Payment_Method,
        @SerializedName("company_bank_account") val company_bank_account: Company_Bank_Account,
        @SerializedName("phone_number") val phone_number: String,
        @SerializedName("status") val status: String,
        @SerializedName("committed") val committed: Boolean,
        @SerializedName("paid") val paid: String,
        @SerializedName("sms_recharge_scheme") val sms_recharge_scheme: String,
        @SerializedName("phone_number_service") val phone_number_service: String,
        @SerializedName("mobile_recharge_card_id") val mobile_recharge_card_id: String,
        @SerializedName("transaction_id") val transaction_id: String,
        @SerializedName("recharge_code") val recharge_code: String,
        @SerializedName("recharge_price") val recharge_price: String,
        @SerializedName("amount_of_utts") val amount_of_utts: String,
        @SerializedName("validity_days") val validity_days: String,
        @SerializedName("mobile_operator_name") val mobile_operator_name: String,
        @SerializedName("mobile_operator_type") val mobile_operator_type: String,
        @SerializedName("amount_paid") val amount_paid: String,
        @SerializedName("created_at") val created_at: String,
        @SerializedName("ussd_recharge_scheme") val ussd_recharge_scheme: String,
        @SerializedName("serial_number") val serial_number: String,
        @SerializedName("description") val description: String,
        @SerializedName("transaction_type") val transaction_type: String,
        @SerializedName("reference_checkout") val reference_checkout: String,
        @SerializedName("reference_recharge") val reference_recharge: String,
        @SerializedName("receipt_image") val receipt_image: String,
        @SerializedName("expires_at") val expires_at: String

    ) {
}

