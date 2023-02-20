package com.example.sportapp.responses

import com.google.gson.annotations.SerializedName

class UserServiceResponse(
    @SerializedName("name")
    var name: String,
    @SerializedName("idUser")
    var idUser: Int,
    @SerializedName("lastName")
    var lastName: String,
    @SerializedName("identificationNumber")
    var identificationNumber: String,
    @SerializedName("consume-services")
    var `consume_services`: List<Result>
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