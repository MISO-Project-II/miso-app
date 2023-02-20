package com.example.sportapp.repostitories

import com.example.sportapp.api.EventApi
import com.example.sportapp.api.ServiceApi
import com.example.sportapp.responses.EventResponse
import com.example.sportapp.responses.ServiceResponse
import retrofit2.Response

class EventRepository {

    suspend fun event(): Response<EventResponse>? {
        return  EventApi.getApi()?.event()
    }

}