package com.example.sportapp.responses

import com.google.gson.annotations.SerializedName
import java.time.format.DateTimeFormatter
import java.util.Date

class GeneralDataResponse (
    @SerializedName("message")
    var message: String,
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("result")
    var `result`: Result,
) {
    data class Result(
        @SerializedName("username")
        var userName: String,
        @SerializedName("name")
        var name: String,
        @SerializedName("lastName")
        var lastName: String,
        @SerializedName("idIdentificationType")
        var idIdentificationType: String,
        @SerializedName("identificationNumber")
        var identificationNumber: String,
        @SerializedName("gender")
        var gender: String,
        @SerializedName("weight")
        var weight: String,
        @SerializedName("age")
        var age: Date,
        @SerializedName("height")
        var height: String,
    )
}