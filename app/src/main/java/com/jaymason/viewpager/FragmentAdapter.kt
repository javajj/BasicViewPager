package com.jaymason.viewpager

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter ( activity : AppCompatActivity, val itemsCount : Int) : FragmentStateAdapter(activity) {


    override fun getItemCount(): Int
    {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        return DoppelgangerFragment.getInstance(position)
    }
}