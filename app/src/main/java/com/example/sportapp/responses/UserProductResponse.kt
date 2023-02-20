package com.example.sportapp.responses

import com.google.gson.annotations.SerializedName

class UserProductResponse(
    @SerializedName("consume-product")
    var `consume-product`: List<Result>,
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