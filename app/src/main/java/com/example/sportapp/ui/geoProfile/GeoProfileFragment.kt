package com.example.sportapp.ui.geoProfile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sportapp.R

class GeoProfileFragment : Fragment() {

    companion object {
        fun newInstance() = GeoProfileFragment()
    }

    private lateinit var viewModel: GeoProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_geo_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GeoProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}