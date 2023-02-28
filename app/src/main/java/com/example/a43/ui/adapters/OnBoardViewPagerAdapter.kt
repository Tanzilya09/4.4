package com.example.a43.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a43.ui.fragments.onBoard.OnBoardPadingFragment
import com.example.a43.ui.fragments.onBoard.OnBoardPadingFragment.Companion.ARG_ONBOARD_PAGE_POSITION

class OnBoardViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment = OnBoardPadingFragment().apply{
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_PAGE_POSITION, position)
        }
    }
}