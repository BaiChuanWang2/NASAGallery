package com.example.nasagallery

import android.app.Application
import com.example.nasagallery.data.api.VolleyUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        VolleyUtil.initQueue(this)
    }
}