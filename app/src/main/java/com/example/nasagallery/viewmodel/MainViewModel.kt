package com.example.nasagallery.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.nasagallery.R
import com.example.nasagallery.data.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val requestIntent = SingleLiveEvent<Boolean>()

    fun onClick(view: View) {
        when (view.id) {
            R.id.tvRequest -> {
                requestIntent.value = true
            }
        }
    }
}