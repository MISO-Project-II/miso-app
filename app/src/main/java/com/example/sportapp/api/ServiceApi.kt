package com.example.sportapp.api

import com.example.sportapp.responses.ServiceResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ServiceApi {

    @Headers("x-api-key: EqYv56oSln9rs1Kirj8Fc7hzy6wWE6tY3NwtbE1M")
    @GET("service")
    suspend fun service(): Response<ServiceResponse>

    companion object {
        fun getApi(): ServiceApi? {
            return ApiClient.client?.create(ServiceApi::class.java)
        }
    }
}