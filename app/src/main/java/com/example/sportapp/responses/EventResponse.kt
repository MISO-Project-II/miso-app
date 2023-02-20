package com.example.sportapp.responses

import com.google.gson.annotations.SerializedName

class EventResponse(
    @SerializedName("message")
    var message: String,
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("result")
    var `result`: List<Result>,
) {
    data class Result(
        @SerializedName("idEvent")
        var idEvent: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("date")
        var date: String,
        @SerializedName("description")
        var description: String,
        @SerializedName("city")
        var city: String,
        @SerializedName("idSport")
        var idSport: Int
    )
}