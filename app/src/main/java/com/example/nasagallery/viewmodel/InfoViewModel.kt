package com.example.nasagallery.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nasagallery.data.SingleLiveEvent
import com.example.nasagallery.data.model.NASAModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor() : ViewModel() {
    val model = SingleLiveEvent<NASAModel>()
}