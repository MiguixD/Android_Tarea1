package com.example.tarea1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tarea1.R
import com.example.tarea1.databinding.FragmentTabBinding
import com.example.tarea1.viewpager.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class TabFragment : Fragment() {
   private lateinit var binding: FragmentTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerAdapter(requireActivity())
        binding.tabViewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.tabViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.listTab)
                1 -> getString(R.string.favTab)
                else -> ""
            }
        }.attach()
    }

}