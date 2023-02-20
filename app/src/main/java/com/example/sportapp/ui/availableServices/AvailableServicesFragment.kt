package com.example.sportapp.ui.availableServices

import BaseResponse
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportapp.databinding.FragmentAvailableServicesBinding
import com.example.sportapp.models.AvailableServicesViewModel
import com.example.sportapp.responses.ServiceResponse

class AvailableServicesFragment : Fragment() {

    private var _binding: FragmentAvailableServicesBinding? = null
    private val binding get() = _binding!!
    private val viewServiceModel by viewModels<AvailableServicesViewModel>()
    private lateinit var customAdapterService: CustomAdapterService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewServiceModel.serviceResult.observe(viewLifecycleOwner) {
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

        viewServiceModel.availableService()

        _binding = FragmentAvailableServicesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    fun processData(data: ServiceResponse?) {
        if (data?.success == true) {
            val recyclerView: RecyclerView? = _binding?.recyclerView
            val llm = LinearLayoutManager(this.context)
            llm.orientation = LinearLayoutManager.VERTICAL
            customAdapterService = CustomAdapterService(data.result)
            recyclerView?.layoutManager = llm
            recyclerView?.adapter = customAdapterService
        }
    }

    fun processError(msg: String?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}