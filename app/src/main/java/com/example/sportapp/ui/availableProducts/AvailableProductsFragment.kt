package com.example.sportapp.ui.availableProducts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportapp.databinding.FragmentAvailableProductsBinding
import com.example.sportapp.databinding.FragmentAvailableServicesBinding
import com.example.sportapp.models.AvailableProductsViewModel
import com.example.sportapp.responses.ProductResponse
import com.example.sportapp.responses.ServiceResponse
import com.example.sportapp.ui.availableServices.CustomAdapterService

class AvailableProductsFragment : Fragment() {

    private var _binding: FragmentAvailableProductsBinding? = null
    private val binding get() = _binding!!
    private val viewProductModel by viewModels<AvailableProductsViewModel>()
    private lateinit var customAdapterProduct: CustomAdapterProduct

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewProductModel.productResult.observe(viewLifecycleOwner) {
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

        viewProductModel.availableProduct()

        _binding = FragmentAvailableProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    fun processData(data: ProductResponse?) {
        if (data?.success == true) {
            val recyclerView: RecyclerView? = _binding?.recyclerViewProducts
            val llm = LinearLayoutManager(this.context)
            llm.orientation = LinearLayoutManager.VERTICAL
            customAdapterProduct = CustomAdapterProduct(data.result)
            recyclerView?.layoutManager = llm
            recyclerView?.adapter = customAdapterProduct
        }
    }

    fun processError(msg: String?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}