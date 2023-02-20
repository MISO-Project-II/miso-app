package com.example.sportapp.ui.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sportapp.R
import com.example.sportapp.databinding.FragmentEventsBinding
import com.example.sportapp.ui.availableEvents.AvailableEventsFragment
import com.example.sportapp.ui.userEvents.UserEventsFragment

class EventsFragment : Fragment() {

    private var _binding: FragmentEventsBinding? = null
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
        _binding = FragmentEventsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        loadFragment(AvailableEventsFragment(),data)

        binding.bottomNavigationEvents.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.nav_events_available -> {
                    fragment = AvailableEventsFragment()
                    loadFragment(fragment,data)
                    true
                }
                R.id.nav_events_user -> {
                    fragment = UserEventsFragment()
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
            .replace(R.id.containerEvents, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}