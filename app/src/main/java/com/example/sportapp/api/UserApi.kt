package com.example.sportapp.api

import com.example.sportapp.requests.LoginRequest
import com.example.sportapp.responses.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {

    @Headers("x-api-key: EqYv56oSln9rs1Kirj8Fc7hzy6wWE6tY3NwtbE1M")
    @POST("users/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @Headers("x-api-key: EqYv56oSln9rs1Kirj8Fc7hzy6wWE6tY3NwtbE1M")
    @GET("users/general_data/{user}")
    suspend fun generalData(@Path("user") user:Int): Response<GeneralDataResponse>

    @Headers("x-api-key: EqYv56oSln9rs1Kirj8Fc7hzy6wWE6tY3NwtbE1M")
    @GET("users/{user}/service/consume")
    suspend fun userService(@Path("user") user:Int): Response<UserServiceResponse>

    @Headers("x-api-key: EqYv56oSln9rs1Kirj8Fc7hzy6wWE6tY3NwtbE1M")
    @GET("users/{user}/event/consume")
    suspend fun userEvent(@Path("user") user:Int): Response<UserEventResponse>

    @Headers("x-api-key: EqYv56oSln9rs1Kirj8Fc7hzy6wWE6tY3NwtbE1M")
    @GET("users/{user}/product/consume")
    suspend fun userProduct(@Path("user") user:Int): Response<UserProductResponse>

    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)
        }
    }
}