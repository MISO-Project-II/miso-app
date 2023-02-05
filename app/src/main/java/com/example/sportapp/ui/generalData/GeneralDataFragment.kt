package com.example.sportapp.ui.generalData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sportapp.databinding.FragmentGeneralDataBinding

class GeneralDataFragment : Fragment() {

    private var _binding: FragmentGeneralDataBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val generalDataViewModel =
            ViewModelProvider(this).get(GeneralDataViewModel::class.java)

        _binding = FragmentGeneralDataBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textGallery
        generalDataViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}