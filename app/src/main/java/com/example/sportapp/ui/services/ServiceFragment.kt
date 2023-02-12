package com.example.sportapp.ui.services

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sportapp.R
import com.example.sportapp.databinding.FragmentServiceBinding
import com.example.sportapp.ui.availableServices.AvailableServicesFragment
import com.example.sportapp.ui.generalData.GeneralDataFragment
import com.example.sportapp.ui.userServices.UserServicesFragment

class ServiceFragment : Fragment() {

    private var _binding: FragmentServiceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val servicesViewModel = ViewModelProvider(this).get(ServicesViewModel::class.java)

        _binding = FragmentServiceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        loadFragment(AvailableServicesFragment())

        binding.bottomNavigationServices.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.nav_services_available -> {
                    fragment = AvailableServicesFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.nav_services_user -> {
                    fragment = UserServicesFragment()
                    loadFragment(fragment)
                    true
                }
                else -> false
            }

        }

        return root
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        childFragmentManager.beginTransaction()
            .replace(R.id.containerServices, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}