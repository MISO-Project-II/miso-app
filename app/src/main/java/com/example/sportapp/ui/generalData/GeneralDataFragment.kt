package com.example.sportapp.ui.generalData

import BaseResponse
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sportapp.databinding.FragmentGeneralDataBinding
import com.example.sportapp.models.GeneralDataUserViewModel
import com.example.sportapp.responses.GeneralDataResponse
import java.util.*

class GeneralDataFragment : Fragment() {

    private var _binding: FragmentGeneralDataBinding? = null
    private val binding get() = _binding!!
    private val viewGeneralModel by viewModels<GeneralDataUserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var id = ""

        arguments?.let {
            id = it.getString("id")!!
        }

        viewGeneralModel.generalResult.observe(viewLifecycleOwner) {
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
            viewGeneralModel.generalDataUser(id.toInt())
        }

        _binding = FragmentGeneralDataBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    fun processData(data: GeneralDataResponse?) {
        if (data?.success == true) {
            val diff: Long = Date().getTime() - data.result.age.getTime()
            _binding?.genUsername?.text = data.result.userName
            _binding?.genName?.setText(data.result.name)
            _binding?.genLastName?.setText(data.result.lastName)
            _binding?.genTypeIden?.text = data.result.idIdentificationType
            _binding?.genNumIden?.setText(data.result.identificationNumber)
            _binding?.genNumIden?.setText(data.result.identificationNumber)
            _binding?.genGen?.text = data.result.gender
            _binding?.genWeight?.setText(data.result.weight)
            _binding?.genAge?.text = diff.toString()
            _binding?.genHeight?.setText(data.result.height)
        }
    }
    fun processError(msg: String?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}