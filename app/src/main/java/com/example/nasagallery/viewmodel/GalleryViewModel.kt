package com.example.nasagallery.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasagallery.R
import com.example.nasagallery.data.SingleLiveEvent
import com.example.nasagallery.data.model.NASAModel
import com.example.nasagallery.data.repository.GalleryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor() : ViewModel() {
    @Inject lateinit var repository: GalleryRepository
    val modelList = SingleLiveEvent<List<NASAModel>>()
    val loading = SingleLiveEvent<Boolean>()
    val intent = SingleLiveEvent<NASAModel>()

    fun requestNASA() = viewModelScope.launch {
        val response = repository.requestNASA()
            .asFlow()
            .onStart {
                loading.value = true
            }.toList()
        loading.value = false
        modelList.postValue(response)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.clRoot -> {
                intent.value = view.tag as NASAModel
            }
        }
    }
}