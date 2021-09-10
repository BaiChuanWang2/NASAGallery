package com.example.nasagallery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.nasagallery.R
import com.example.nasagallery.common.ExtraUtils
import com.example.nasagallery.common.Utils
import com.example.nasagallery.databinding.FragmentInfoBinding
import com.example.nasagallery.viewmodel.InfoViewModel

class InfoFragment : BaseFragment() {
    private lateinit var binding: FragmentInfoBinding
    private val viewModel by viewModels<InfoViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if (!this::binding.isInitialized) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
            binding.viewModel = viewModel
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
    }

    private fun initViewModel() {
        viewModel.apply {
            model.observe(viewLifecycleOwner, {
                binding.tvDate.text = Utils.dateFormat(it.date)
                binding.tvTitle.text = it.title
                binding.tvCopyright.text = it.copyright
                binding.tvDescription.text = it.description
                Utils.srcUrl(binding.ivHdUrl, it.hdurl)
            })
        }
    }

    private fun initData() {
        arguments?.apply {
            viewModel.model.value = getParcelable(ExtraUtils.EXTRA_DATA)
        }
    }
}