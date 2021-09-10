package com.example.nasagallery.common

import android.graphics.Bitmap
import androidx.collection.LruCache
import com.android.volley.toolbox.ImageLoader

class BitmapCache: ImageLoader.ImageCache {
    private val lruCache: LruCache<String, Bitmap>
    private val max = 10 * 1024 * 1024

    init {
        lruCache = LruCache(max)
    }

    override fun getBitmap(url: String): Bitmap? {
        return lruCache.get(url)
    }

    override fun putBitmap(url: String, bitmap: Bitmap) {
        lruCache.put(url, bitmap)
    }
}