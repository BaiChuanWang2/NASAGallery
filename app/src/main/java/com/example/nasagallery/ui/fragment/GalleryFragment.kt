package com.example.nasagallery.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nasagallery.R
import com.example.nasagallery.common.ExtraUtils
import com.example.nasagallery.databinding.FragmentGalleryBinding
import com.example.nasagallery.ui.adapter.GalleryAdapter
import com.example.nasagallery.viewmodel.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : BaseFragment() {
    private lateinit var binding: FragmentGalleryBinding
    private val viewModel by viewModels<GalleryViewModel>()
    private lateinit var adapter: GalleryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if (!this::binding.isInitialized) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery, container, false)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initViewModel()
        initData()
    }

    private fun initUI() {
        initToolbar(binding.includeToolbar.toolbar)
        if (!this::adapter.isInitialized) {
            binding.apply {
                adapter = GalleryAdapter(requireContext(), viewModel)
                rv.layoutManager = GridLayoutManager(requireContext(), 4)
                rv.adapter = adapter
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel() {
        viewModel.apply {
            modelList.observe(viewLifecycleOwner, {
                adapter.submitList(it)
            })
            loading.observe(viewLifecycleOwner, {
                binding.pb.visibility = if (it) View.VISIBLE else View.GONE
            })
            intent.observe(viewLifecycleOwner, {
                Bundle().apply {
                    putParcelable(ExtraUtils.EXTRA_DATA, it)
                    findNavController().navigate(R.id.nav_info, this)
                }
            })
        }
    }

    private fun initData() {
        viewModel.requestNASA()
    }
}