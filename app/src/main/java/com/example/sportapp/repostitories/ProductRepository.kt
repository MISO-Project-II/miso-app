package com.example.sportapp.repostitories

import com.example.sportapp.api.ProductApi
import com.example.sportapp.responses.ProductResponse
import retrofit2.Response

class ProductRepository {
    suspend fun product(): Response<ProductResponse>? {
        return  ProductApi.getApi()?.service()
    }
}