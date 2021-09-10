package com.example.nasagallery.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NASAModel(val description: String,
                     val copyright: String,
                     val title: String,
                     val date: String,
                     val hdurl: String) : Parcelable