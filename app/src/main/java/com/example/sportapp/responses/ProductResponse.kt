package com.example.sportapp.responses

import com.google.gson.annotations.SerializedName

class ProductResponse (
    @SerializedName("message")
    var message: String,
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("result")
    var `result`: List<Result>,
) {
    data class Result(
        @SerializedName("idProduct")
        var idProduct: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("description")
        var description: String,
        @SerializedName("idSport")
        var idsport: Int,
    )
}