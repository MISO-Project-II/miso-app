package com.example.sportapp.ui.service

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sportapp.R
import com.example.sportapp.databinding.FragmentProfileBinding
import com.example.sportapp.databinding.FragmentServiceBinding
import com.example.sportapp.ui.foodProfile.FoodProfileFragment
import com.example.sportapp.ui.generalData.GeneralDataFragment
import com.example.sportapp.ui.geoProfile.GeoProfileFragment
import com.example.sportapp.ui.profile.ProfileViewModel
import com.example.sportapp.ui.sportProfile.SportProfileFragment

class ServiceFragment : Fragment() {

    private var _binding: FragmentServiceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentServiceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

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