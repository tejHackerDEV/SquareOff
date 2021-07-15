package com.samba.squareoff.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.samba.squareoff.R
import com.samba.squareoff.databinding.ActivityMainBinding
import com.samba.squareoff.recycler_view.adapter.RvAdapter
import com.samba.squareoff.utils.Resource
import com.samba.squareoff.view_model.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.fetchedData.observe(this, { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { fetchedData ->
                        binding.rvId.apply {
                            adapter = RvAdapter(fetchedData)
                        }
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { errorMsg -> showError(errorMsg) }
                }
            }
        })
    }

    private fun showProgressBar() {
        binding.progressBarId.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBarId.visibility = View.GONE
    }

    private fun showError(errorMsg: String) {
        binding.rvId.visibility = View.GONE
        binding.errTxtId.apply {
            text = errorMsg
            visibility = View.VISIBLE
        }
    }
}