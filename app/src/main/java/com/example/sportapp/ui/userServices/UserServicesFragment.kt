package com.example.sportapp.ui.userServices

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportapp.databinding.FragmentUserServicesBinding
import com.example.sportapp.models.UserServiceViewModel
import com.example.sportapp.responses.UserServiceResponse

class UserServicesFragment : Fragment() {

    private var _binding: FragmentUserServicesBinding? = null
    private val binding get() = _binding!!
    private val viewUserServiceModel by viewModels<UserServiceViewModel>()
    private lateinit var customAdapterUserService: CustomAdapterUserService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var id = ""

        arguments?.let {
            id = it.getString("id")!!
        }

        viewUserServiceModel.serviceUserResult.observe(viewLifecycleOwner) {
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
            viewUserServiceModel.userService(id.toInt())
        }

        _binding = FragmentUserServicesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    fun processData(data: UserServiceResponse?) {
        if (data?.consume_services?.any() == true) {
           val recyclerView: RecyclerView? = _binding?.recyclerViewUserService
           val llm = LinearLayoutManager(this.context?.applicationContext)
           llm.orientation = LinearLayoutManager.VERTICAL
           customAdapterUserService = CustomAdapterUserService(data.consume_services)
           recyclerView?.layoutManager = llm
           recyclerView?.adapter = customAdapterUserService
        }
    }
    fun processError(msg: String?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}