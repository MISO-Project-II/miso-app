package com.example.sportapp.ui.availableEvents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportapp.databinding.FragmentAvailableEventsBinding
import com.example.sportapp.models.AvailableEventsViewModel
import com.example.sportapp.responses.EventResponse

class AvailableEventsFragment : Fragment() {

    private var _binding: FragmentAvailableEventsBinding? = null
    private val binding get() = _binding!!
    private val viewEventModel by viewModels<AvailableEventsViewModel>()
    private lateinit var customAdapterEvent: CustomAdapterEvent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        viewEventModel.eventResult.observe(viewLifecycleOwner) {
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

        viewEventModel.availableEvent()

        _binding = FragmentAvailableEventsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    fun processData(data: EventResponse?) {
        if (data?.success == true) {
            val recyclerView: RecyclerView? = _binding?.recyclerViewEvent
            val llm = LinearLayoutManager(this.context)
            llm.orientation = LinearLayoutManager.VERTICAL
            customAdapterEvent = CustomAdapterEvent(data.result)
            recyclerView?.layoutManager = llm
            recyclerView?.adapter = customAdapterEvent
        }
    }

    fun processError(msg: String?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}