package io.github.captainwonjong.sample.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.captainwonjong.sample.type.TabType
import kotlinx.coroutines.flow.StateFlow

class TabPageAdapter(
    private val activity: FragmentActivity,
    private val tabs: StateFlow<List<TabType>>,
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = tabs.value.size

    override fun createFragment(position: Int): Fragment = activity.supportFragmentManager.fragmentFactory.instantiate(
        activity.classLoader,
        tabs.value[position].fragmentClass.name.toString()
    )
}