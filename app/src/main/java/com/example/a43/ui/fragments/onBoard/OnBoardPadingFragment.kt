package com.example.a43.ui.fragments.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a43.R
import com.example.a43.databinding.FragmentOnBoardPadingBinding

class OnBoardPadingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPadingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_PAGE_POSITION)) {
            0 -> {
                tvText.text = "Очень удобный функционал"
                lottie.setAnimation(R.raw.lottie1)
            }
            1 -> {
                tvText.text = "Быстрый, качественный продукт"
                lottie.setAnimation(R.raw.lottie2)
            }
            2 -> {
                tvText.text = "Куча функций и интересных фишек"
                lottie.setAnimation(R.raw.lottie3)
            }
        }
    }

    companion object {
        const val ARG_ONBOARD_PAGE_POSITION = "onBoardPage"
    }
}