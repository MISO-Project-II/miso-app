package com.example.sportapp.models

import BaseResponse
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sportapp.repostitories.UserRepository
import com.example.sportapp.responses.UserProductResponse
import com.example.sportapp.responses.UserServiceResponse
import kotlinx.coroutines.launch

class UserProductViewModel(application: Application) : AndroidViewModel(application) {

    val userRepo = UserRepository()
    val productUserResult: MutableLiveData<BaseResponse<UserProductResponse>> = MutableLiveData()

    fun availableService(user: Int) {

        productUserResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val response = userRepo.userProduct(user = user)
                if (response?.code() == 200) {
                    productUserResult.value = BaseResponse.Success(response.body())
                } else {
                    productUserResult.value = BaseResponse.Error(response?.message())
                }
            } catch (ex: Exception) {
                productUserResult.value = BaseResponse.Error(ex.message)
            }
        }
    }
}