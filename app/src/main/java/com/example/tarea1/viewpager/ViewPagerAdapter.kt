package com.example.tarea1.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tarea1.fragments.FavFragment
import com.example.tarea1.fragments.ListFragment
import com.example.tarea1.fragments.RegisterFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ListFragment()
            1 -> FavFragment()
            2 -> RegisterFragment()
            else -> throw IllegalStateException("Invalid position")
        }
    }

    override fun getItemCount(): Int = 3

}