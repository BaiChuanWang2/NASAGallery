package com.example.nasagallery.common

import android.annotation.SuppressLint
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.NetworkImageView
import com.example.nasagallery.R
import com.example.nasagallery.data.api.VolleyUtil
import java.text.SimpleDateFormat

object Utils {
    fun srcUrl(iv: NetworkImageView, url: String) {
        val loader = ImageLoader(VolleyUtil.getQueue(), BitmapCache())
        iv.setDefaultImageResId(R.drawable.ic_hourglass_empty_black)
        iv.setErrorImageResId(R.drawable.ic_baseline_sentiment_very_dissatisfied)
        iv.setImageUrl(url, loader)
    }

    @SuppressLint("SimpleDateFormat")
    fun dateFormat(text: String): String {
        val sdfToDate = SimpleDateFormat("yyyy-MM-dd")
        val date = sdfToDate.parse(text)
        val sdfToText = SimpleDateFormat("yyyy MMM. dd")
        return sdfToText.format(date!!)
    }
}