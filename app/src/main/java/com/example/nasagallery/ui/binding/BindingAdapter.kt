package com.example.nasagallery.ui.binding

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.android.volley.toolbox.NetworkImageView
import com.example.nasagallery.common.Utils

@BindingAdapter("bindingSrcUrl")
fun bindingSrcUrl(iv: NetworkImageView, url: String) {
    Utils.srcUrl(iv, url)
}

@BindingAdapter("bindingText")
fun bindingText(tv: AppCompatTextView, text: String) {
    tv.text = text
}