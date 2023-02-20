package com.example.sportapp.responses

import com.google.gson.annotations.SerializedName

class ServiceResponse(
    @SerializedName("message")
    var message: String,
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("result")
    var `result`: List<Result>,
) {
    data class Result(
        @SerializedName("id")
        var id: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("description")
        var description: String,
        @SerializedName("idSport")
        var idsport: Int,
        @SerializedName("price")
        var price: Double,
        @SerializedName("contract")
        var contract: String
    )
}