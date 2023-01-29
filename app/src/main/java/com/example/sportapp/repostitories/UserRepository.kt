package com.example.sportapp.repostitories

import com.example.sportapp.api.UserApi
import com.example.sportapp.requests.LoginRequest
import com.example.sportapp.responses.LoginResponse
import retrofit2.Response

class UserRepository {

    suspend fun loginUser(loginRequest:LoginRequest): Response<LoginResponse>? {
        return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }
}