package com.example.sportapp.responses

import com.google.gson.annotations.SerializedName


data class LoginResponse(
    @SerializedName("message")
    var message: String,
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("token")
    var token: String,
    @SerializedName("userId")
    var userId: String,
    @SerializedName("user")
    var `user`: User,
) {
    data class User(
        @SerializedName("lastName")
        var lastName: String,
        @SerializedName("name")
        var name: String,
        @SerializedName("numberIdentification")
        var numberIdentification: String,
        @SerializedName("userType")
        var userType: String,
        @SerializedName("username")
        var username: String
    )
}