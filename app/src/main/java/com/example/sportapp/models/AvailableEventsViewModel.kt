package com.example.sportapp.models

import BaseResponse
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sportapp.repostitories.EventRepository
import com.example.sportapp.responses.EventResponse
import kotlinx.coroutines.launch

class AvailableEventsViewModel(application: Application) : AndroidViewModel(application) {

    val eventRepo = EventRepository()
    val eventResult: MutableLiveData<BaseResponse<EventResponse>> = MutableLiveData()

    fun availableEvent() {

        eventResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val response = eventRepo.event()
                if (response?.code() == 200) {
                    eventResult.value = BaseResponse.Success(response.body())
                } else {
                    eventResult.value = BaseResponse.Error(response?.message())
                }
            } catch (ex: Exception) {
                eventResult.value = BaseResponse.Error(ex.message)
            }
        }
    }
}