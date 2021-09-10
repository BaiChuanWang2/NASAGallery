package com.example.nasagallery.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nasagallery.R
import com.example.nasagallery.data.model.NASAModel
import com.example.nasagallery.databinding.AdapterGalleryBinding
import com.example.nasagallery.viewmodel.GalleryViewModel

class GalleryAdapter constructor(context: Context, private val viewModel: GalleryViewModel) : ListAdapter<NASAModel, GalleryAdapter.ViewHolder>(DiffCallback) {
    private val inflater = LayoutInflater.from(context)

    class ViewHolder constructor(private val binding: AdapterGalleryBinding, private val galleryViewModel: GalleryViewModel) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(dataModel: NASAModel) {
            binding.apply {
                binding.viewModel = galleryViewModel
                binding.dataModel = dataModel
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: AdapterGalleryBinding = DataBindingUtil.inflate(inflater, R.layout.adapter_gallery, parent, false)
        return ViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = viewModel.modelList.value!![position]
        holder.bindView(dataModel)
    }

    object DiffCallback: DiffUtil.ItemCallback<NASAModel>() {
        override fun areItemsTheSame(oldItem: NASAModel, newItem: NASAModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NASAModel, newItem: NASAModel): Boolean {
            return oldItem.title == newItem.title
        }
    }
}