package com.example.sportapp.models

import BaseResponse
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sportapp.repostitories.ProductRepository
import com.example.sportapp.responses.ProductResponse
import kotlinx.coroutines.launch

class AvailableProductsViewModel(application: Application) : AndroidViewModel(application)  {

    val productRepo = ProductRepository()
    val productResult: MutableLiveData<BaseResponse<ProductResponse>> = MutableLiveData()

    fun availableProduct() {

        productResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val response = productRepo.product()
                if (response?.code() == 200) {
                    productResult.value = BaseResponse.Success(response.body())
                } else {
                    productResult.value = BaseResponse.Error(response?.message())
                }
            } catch (ex: Exception) {
                productResult.value = BaseResponse.Error(ex.message)
            }
        }
    }
}