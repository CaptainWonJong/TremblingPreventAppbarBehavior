package io.github.captainwonjong.sample.utils

import android.annotation.SuppressLint
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.databinding.BindingAdapter

@BindingAdapter("loadUrl")
fun WebView.loadUrl(url: String?) {
    settings.apply {
        loadWithOverviewMode = true
        useWideViewPort = true
        builtInZoomControls = false
        displayZoomControls = false
        domStorageEnabled = true
        textZoom = 100
        cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

        @SuppressLint("SetJavaScriptEnabled")
        javaScriptEnabled = true
    }
    loadUrl(url ?: return)
}
