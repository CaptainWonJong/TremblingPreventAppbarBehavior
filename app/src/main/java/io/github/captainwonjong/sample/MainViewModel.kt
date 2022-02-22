package io.github.captainwonjong.sample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import io.github.captainwonjong.sample.type.TabType
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.plus

class MainViewModel: ViewModel() {
    private val scope = viewModelScope + CoroutineExceptionHandler { _, e ->
        Log.e("error", e.toString())
    }

    private val _tabs: MutableStateFlow<List<TabType>> = MutableStateFlow<List<TabType>>(listOf(TabType.Tab1, TabType.Tab2))
    val tabs: StateFlow<List<TabType>> = _tabs.asStateFlow()

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                MainViewModel() as? T ?: throw IllegalArgumentException()
            } else {
                throw IllegalArgumentException()
            }
    }
}