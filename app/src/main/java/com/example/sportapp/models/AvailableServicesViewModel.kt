package com.example.sportapp.models

import BaseResponse
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sportapp.repostitories.ServicesRepository
import com.example.sportapp.responses.ServiceResponse
import kotlinx.coroutines.launch

class AvailableServicesViewModel(application: Application) : AndroidViewModel(application) {

    val serviceRepo = ServicesRepository()
    val serviceResult: MutableLiveData<BaseResponse<ServiceResponse>> = MutableLiveData()

    fun availableService() {

        serviceResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val response = serviceRepo.service()
                if (response?.code() == 200) {
                    serviceResult.value = BaseResponse.Success(response.body())
                } else {
                    serviceResult.value = BaseResponse.Error(response?.message())
                }
            } catch (ex: Exception) {
                serviceResult.value = BaseResponse.Error(ex.message)
            }
        }
    }
}