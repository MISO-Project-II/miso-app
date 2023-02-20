package com.example.sportapp.repostitories

import com.example.sportapp.api.ServiceApi
import com.example.sportapp.responses.ServiceResponse
import com.example.sportapp.responses.UserServiceResponse
import retrofit2.Response

class ServicesRepository {

    suspend fun service(): Response<ServiceResponse>? {
        return  ServiceApi.getApi()?.service()
    }

}