package com.example.nasagallery.data.api

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.nasagallery.common.config.ApiConfig
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object VolleyUtil {
    private lateinit var queue: RequestQueue

    fun initQueue(context: Context) {
        queue = Volley.newRequestQueue(context)
    }

    fun getQueue() = queue

    suspend fun request(url: String) = suspendCoroutine<String> {
        StringRequest(Request.Method.GET, ApiConfig.DOMAIN + url, { response ->
            it.resume(response)
        }, null).let {
            queue.add(it)
        }
    }
}