package com.example.sportapp.models

import BaseResponse
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sportapp.repostitories.UserRepository
import com.example.sportapp.responses.UserEventResponse
import com.example.sportapp.responses.UserServiceResponse
import kotlinx.coroutines.launch

class UserEventViewModel (application: Application) : AndroidViewModel(application) {

    val userRepo = UserRepository()
    val eventUserResult: MutableLiveData<BaseResponse<UserEventResponse>> = MutableLiveData()

    fun availableEvent(user: Int) {

        eventUserResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val response = userRepo.userEvent(user = user)
                if (response?.code() == 200) {
                    eventUserResult.value = BaseResponse.Success(response.body())
                } else {
                    eventUserResult.value = BaseResponse.Error(response?.message())
                }
            } catch (ex: Exception) {
                eventUserResult.value = BaseResponse.Error(ex.message)
            }
        }
    }
}