package com.example.sportapp.ui.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sportapp.R
import com.example.sportapp.databinding.FragmentProductsBinding
import com.example.sportapp.ui.availableProducts.AvailableProductsFragment
import com.example.sportapp.ui.userProducts.UserProductsFragment


class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var id = ""
        arguments?.let {
            id = it.getString("id")!!
        }
        val data = Bundle()

        data.putString("id",id)
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        loadFragment(AvailableProductsFragment(),data)

        binding.bottomNavigationProducts.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.nav_products_available -> {
                    fragment = AvailableProductsFragment()
                    loadFragment(fragment,data)
                    true
                }
                R.id.nav_products_user -> {
                    fragment = UserProductsFragment()
                    loadFragment(fragment,data)
                    true
                }
                else -> false
            }

        }

        return root
    }

    private fun loadFragment(fragment: Fragment,data:Bundle) {
        fragment.setArguments(data)
        childFragmentManager.beginTransaction()
            .replace(R.id.containerProducts, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}