package com.example.sportapp.models

import BaseResponse
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sportapp.repostitories.UserRepository
import com.example.sportapp.responses.GeneralDataResponse
import kotlinx.coroutines.launch

class GeneralDataUserViewModel(application: Application) : AndroidViewModel(application) {

    val userRepo = UserRepository()
    val generalResult: MutableLiveData<BaseResponse<GeneralDataResponse>> = MutableLiveData()

    fun generalDataUser(user: Int) {

        generalResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val response = userRepo.generalDataUser(user = user)
                if (response?.code() == 200) {
                    generalResult.value = BaseResponse.Success(response.body())
                } else {
                    generalResult.value = BaseResponse.Error(response?.message())
                }
            } catch (ex: Exception) {
                generalResult.value = BaseResponse.Error(ex.message)
            }
        }
    }
}