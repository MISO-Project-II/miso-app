package com.example.sportapp.api

import com.example.sportapp.requests.LoginRequest
import com.example.sportapp.responses.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserApi {

    @Headers("x-api-key: EqYv56oSln9rs1Kirj8Fc7hzy6wWE6tY3NwtbE1M")
    @POST("users/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)
        }
    }
}