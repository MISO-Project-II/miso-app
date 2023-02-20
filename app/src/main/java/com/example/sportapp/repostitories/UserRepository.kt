package com.example.sportapp.repostitories

import com.example.sportapp.api.ServiceApi
import com.example.sportapp.api.UserApi
import com.example.sportapp.requests.LoginRequest
import com.example.sportapp.responses.*
import retrofit2.Response

class UserRepository {

    suspend fun loginUser(loginRequest:LoginRequest): Response<LoginResponse>? {
        return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }

    suspend fun generalDataUser(user:Int): Response<GeneralDataResponse>? {
        return  UserApi.getApi()?.generalData(user = user)
    }

    suspend fun userService(user:Int): Response<UserServiceResponse>? {
        return  UserApi.getApi()?.userService(user = user)
    }

    suspend fun userEvent(user:Int): Response<UserEventResponse>? {
        return  UserApi.getApi()?.userEvent(user = user)
    }

    suspend fun userProduct(user:Int): Response<UserProductResponse>? {
        return  UserApi.getApi()?.userProduct(user = user)
    }
}