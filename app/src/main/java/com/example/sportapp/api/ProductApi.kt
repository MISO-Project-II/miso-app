package com.example.sportapp.api

import com.example.sportapp.responses.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ProductApi {
    @Headers("x-api-key: EqYv56oSln9rs1Kirj8Fc7hzy6wWE6tY3NwtbE1M")
    @GET("product")
    suspend fun service(): Response<ProductResponse>

    companion object {
        fun getApi(): ProductApi? {
            return ApiClient.client?.create(ProductApi::class.java)
        }
    }
}