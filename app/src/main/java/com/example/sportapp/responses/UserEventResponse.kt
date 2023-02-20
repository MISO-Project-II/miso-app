package com.example.sportapp.responses

import com.google.gson.annotations.SerializedName

class UserEventResponse(
    @SerializedName("consume-events")
    var `consume-event`: List<Result>,
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