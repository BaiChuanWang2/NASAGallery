package com.example.nasagallery.ui.fragment

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.nasagallery.R

open class BaseFragment : Fragment() {
    fun initToolbar(toolbar: Toolbar) {
        setHasOptionsMenu(true)
        (requireActivity() as AppCompatActivity).apply {
            setSupportActionBar(toolbar)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setHomeAsUpIndicator(R.drawable.ic_baseline_navigate_before)
                title = getString(R.string.back)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            (requireActivity() as AppCompatActivity).onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}