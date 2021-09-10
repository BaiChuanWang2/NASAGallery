package com.example.nasagallery.data.repository

import com.example.nasagallery.data.api.VolleyUtil
import com.example.nasagallery.data.model.NASAModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class GalleryRepository @Inject constructor() {
    suspend fun requestNASA() = VolleyUtil.request("main/apod.json").let {
        val type = object: TypeToken<ArrayList<NASAModel>>() {}.type
        Gson().fromJson<List<NASAModel>>(it, type)
    }
}