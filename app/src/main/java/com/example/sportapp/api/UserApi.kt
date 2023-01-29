package com.example.sportapp.api

import com.example.sportapp.requests.LoginRequest
import com.example.sportapp.responses.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("login?apikey=pfHfQuIZc4I8a5Rzf8D7S7Irw6FGMOdyJ9v3fH0b9xAGg4Ed")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)
        }
    }
}