package com.example.a43.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.a43.R
import com.example.a43.databinding.FragmentOnBoardBinding
import com.example.a43.ui.adapters.OnBoardViewPagerAdapter
import com.example.a43.utils.PreferenceHelper

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
        binding.viewPager.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
        binding.dotsIndicator.attachTo(binding.viewPager)
    }

    private fun setupListener() = with(binding) {
        btn.setOnClickListener {
            with(viewPager) {
                if (currentItem < 2) {
                    setCurrentItem(viewPager.currentItem + 1, true)
                }
            }
        }
        binding.work.setOnClickListener {
            val preferenceHelper = PreferenceHelper()
            preferenceHelper.unit(requireContext())
            preferenceHelper.onSaveOnBoardState = false
            findNavController().navigate(R.id.action_onBoardFragment_to_noteAppFragment)
        }
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        btn.isVisible = true
                        work.isVisible = false
                    }
                    1 -> {
                        btn.isVisible = true
                            work.isVisible = false
                    }
                    2 -> {
                        btn.isVisible = false
                        work.isVisible = true
                    }
                }
                super.onPageSelected(position)
            }
        })
    }
}