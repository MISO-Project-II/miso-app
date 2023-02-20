package com.example.sportapp.api

import com.example.sportapp.responses.EventResponse
import com.example.sportapp.responses.ServiceResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface EventApi {
    @Headers("x-api-key: EqYv56oSln9rs1Kirj8Fc7hzy6wWE6tY3NwtbE1M")
    @GET("event")
    suspend fun event(): Response<EventResponse>

    companion object {
        fun getApi(): EventApi? {
            return ApiClient.client?.create(EventApi::class.java)
        }
    }
}