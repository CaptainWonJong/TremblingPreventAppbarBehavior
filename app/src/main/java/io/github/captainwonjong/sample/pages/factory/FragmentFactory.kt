package io.github.captainwonjong.sample.pages.factory

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import io.github.captainwonjong.sample.pages.Tab1Fragment
import io.github.captainwonjong.sample.pages.Tab2Fragment

class FragmentFactory(
    private val value: Int
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment =
        when (loadFragmentClass(classLoader, className)) {
            Tab1Fragment::class.java -> {
                Tab1Fragment()
            }
            Tab2Fragment::class.java -> {
                Tab2Fragment().apply {
                    arguments = bundleOf(
                        KEY to value
                    )
                }
            }
            else -> {
                throw IllegalArgumentException("Unknown Fragment : $className")
            }
        }

    companion object {
        internal const val KEY = "Key"
    }
}