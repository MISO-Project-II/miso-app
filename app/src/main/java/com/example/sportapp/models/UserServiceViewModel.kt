package com.example.sportapp.models

import BaseResponse
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sportapp.repostitories.ServicesRepository
import com.example.sportapp.repostitories.UserRepository
import com.example.sportapp.responses.ServiceResponse
import com.example.sportapp.responses.UserServiceResponse
import kotlinx.coroutines.launch

class UserServiceViewModel(application: Application) : AndroidViewModel(application) {

    val userRepo = UserRepository()
    val serviceUserResult: MutableLiveData<BaseResponse<UserServiceResponse>> = MutableLiveData()

    fun userService(user: Int) {

        serviceUserResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val response = userRepo.userService(user = user)
                if (response?.code() == 200) {
                    serviceUserResult.value = BaseResponse.Success(response.body())
                } else {
                    serviceUserResult.value = BaseResponse.Error(response?.message())
                }
            } catch (ex: Exception) {
                serviceUserResult.value = BaseResponse.Error(ex.message)
            }
        }
    }
}