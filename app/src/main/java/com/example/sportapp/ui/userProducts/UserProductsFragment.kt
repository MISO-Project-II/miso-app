package com.example.sportapp.ui.userProducts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportapp.R
import com.example.sportapp.databinding.FragmentUserProductsBinding
import com.example.sportapp.databinding.FragmentUserServicesBinding
import com.example.sportapp.models.UserProductViewModel
import com.example.sportapp.models.UserServiceViewModel
import com.example.sportapp.responses.UserProductResponse
import com.example.sportapp.responses.UserServiceResponse
import com.example.sportapp.ui.userServices.CustomAdapterUserService

class UserProductsFragment : Fragment() {

    private var _binding: FragmentUserProductsBinding? = null
    private val binding get() = _binding!!
    private val viewUserProductModel by viewModels<UserProductViewModel>()
    private lateinit var customAdapterUserProduct: CustomAdapterUserProduct

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var id = ""

        arguments?.let {
            id = it.getString("id")!!
        }

        viewUserProductModel.productUserResult.observe(viewLifecycleOwner) {
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
            viewUserProductModel.availableService(id.toInt())
        }

        _binding = FragmentUserProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    fun processData(data: UserProductResponse?) {
        if (data?.`consume-product`?.any() == true) {
            val recyclerView: RecyclerView? = _binding?.recyclerViewUserProducts
            val llm = LinearLayoutManager(this.context)
            llm.orientation = LinearLayoutManager.VERTICAL
            customAdapterUserProduct = CustomAdapterUserProduct(data.`consume-product`)
            recyclerView?.layoutManager = llm
            recyclerView?.adapter = customAdapterUserProduct
        }
    }
    fun processError(msg: String?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}