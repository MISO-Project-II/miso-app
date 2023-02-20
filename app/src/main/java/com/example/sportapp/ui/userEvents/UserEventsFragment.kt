package com.example.sportapp.ui.userEvents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportapp.R
import com.example.sportapp.databinding.FragmentUserEventsBinding
import com.example.sportapp.databinding.FragmentUserServicesBinding
import com.example.sportapp.models.UserEventViewModel
import com.example.sportapp.models.UserServiceViewModel
import com.example.sportapp.responses.UserEventResponse
import com.example.sportapp.responses.UserServiceResponse
import com.example.sportapp.ui.userServices.CustomAdapterUserService

class UserEventsFragment : Fragment() {

    private var _binding: FragmentUserEventsBinding? = null
    private val binding get() = _binding!!
    private val viewUserEventModel by viewModels<UserEventViewModel>()
    private lateinit var customAdapterUserEvent: CustomAdapterUserEvent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var id = ""

        arguments?.let {
            id = it.getString("id")!!
        }

        viewUserEventModel.eventUserResult.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Success -> {
                    processData(it.data)
                }

                is BaseResponse.Error -> {
                    processError(it.msg)
                }
                else -> {
                    processError("Error Cargando")
                }
            }
        }

        if(!id.isNullOrEmpty() && id != "null"){
            viewUserEventModel.availableEvent(id.toInt())
        }

        _binding = FragmentUserEventsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    fun processData(data: UserEventResponse?) {
        if (data?.`consume-event`?.any() == true) {
            val recyclerView: RecyclerView? = _binding?.recyclerViewUserEvent
            val llm = LinearLayoutManager(this.context)
            llm.orientation = LinearLayoutManager.VERTICAL
            customAdapterUserEvent = CustomAdapterUserEvent(data.`consume-event`)
            recyclerView?.layoutManager = llm
            recyclerView?.adapter = customAdapterUserEvent
        }
    }
    fun processError(msg: String?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}