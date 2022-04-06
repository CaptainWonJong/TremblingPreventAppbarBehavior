package io.github.captainwonjong.sample.type

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import io.github.captainwonjong.sample.R
import io.github.captainwonjong.sample.pages.Tab1Fragment
import io.github.captainwonjong.sample.pages.Tab2Fragment

enum class TabType(@StringRes val tabName: Int, val fragmentClass: Class<out Fragment>) {
    Tab1(R.string.tab1, Tab1Fragment::class.java),
    Tab2(R.string.tab2, Tab2Fragment::class.java),
}
