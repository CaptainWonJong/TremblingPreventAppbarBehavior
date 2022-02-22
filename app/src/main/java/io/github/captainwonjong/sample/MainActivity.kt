package io.github.captainwonjong.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import io.github.captainwonjong.sample.adapter.TabPageAdapter
import io.github.captainwonjong.sample.databinding.ActivityMainBinding
import io.github.captainwonjong.sample.pages.factory.FragmentFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(viewModelStore, MainViewModel.Factory())[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = FragmentFactory(999)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.run {
            lifecycleOwner = this@MainActivity
            model = viewModel
        }
        collectFlows()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun collectFlows() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.tabs.collect { tabType ->
                    binding.pager.adapter = TabPageAdapter(this@MainActivity, viewModel.tabs)
                    TabLayoutMediator(binding.tabs, binding.pager, false) { tab, position ->
                        tab.text = getString(tabType[position].tabName)
                        tab.view.setOnLongClickListener { true }
                    }.attach()
                    binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                        override fun onTabSelected(tab: TabLayout.Tab?) {
                            binding.appbar.setExpanded(false)
                        }

                        override fun onTabUnselected(tab: TabLayout.Tab?) {
                            // Do Nothing
                        }

                        override fun onTabReselected(tab: TabLayout.Tab?) {
                            // Do Nothing
                        }
                    })
                }
            }
        }
    }
}