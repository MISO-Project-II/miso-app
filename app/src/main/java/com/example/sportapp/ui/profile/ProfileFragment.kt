package com.example.sportapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sportapp.R
import com.example.sportapp.databinding.FragmentProfileBinding
import com.example.sportapp.ui.foodProfile.FoodProfileFragment
import com.example.sportapp.ui.generalData.GeneralDataFragment
import com.example.sportapp.ui.geoProfile.GeoProfileFragment
import com.example.sportapp.ui.sportProfile.SportProfileFragment

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        loadFragment(GeneralDataFragment())

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.nav_general -> {
                    fragment = GeneralDataFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.nav_sport -> {
                    fragment = SportProfileFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.nav_food -> {
                    fragment = FoodProfileFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.nav_demographic -> {
                    fragment = GeoProfileFragment()
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
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}