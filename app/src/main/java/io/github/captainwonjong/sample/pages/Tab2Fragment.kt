package io.github.captainwonjong.sample.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import io.github.captainwonjong.sample.R
import io.github.captainwonjong.sample.databinding.FragmentTab2Binding
import io.github.captainwonjong.sample.pages.factory.FragmentFactory

class Tab2Fragment : Fragment() {
    private var _binding: FragmentTab2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate<FragmentTab2Binding>(inflater, R.layout.fragment_tab2, container, false)
        return binding.apply {
            lifecycleOwner = this@Tab2Fragment
            argu = arguments?.getInt(FragmentFactory.KEY)
        }.root
    }
}