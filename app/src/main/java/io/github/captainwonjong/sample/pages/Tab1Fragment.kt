package io.github.captainwonjong.sample.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import io.github.captainwonjong.sample.R
import io.github.captainwonjong.sample.databinding.FragmentTab1Binding

class Tab1Fragment : Fragment() {
    private var _binding: FragmentTab1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate<FragmentTab1Binding>(inflater, R.layout.fragment_tab1, container, false)
        return binding.apply {
            lifecycleOwner = this@Tab1Fragment
            url = "https://github.com/CaptainWonJong/TremblingPreventAppbarBehavior"
        }.root
    }
}