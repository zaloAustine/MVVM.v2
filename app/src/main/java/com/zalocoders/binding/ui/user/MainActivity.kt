package com.zalocoders.binding.ui.user

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.zalocoders.binding.R
import com.zalocoders.binding.data.model.UserResponseItem
import com.zalocoders.binding.databinding.ActivityMainBinding
import com.zalocoders.binding.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.getUsers()
        //set adapter
        initRecyclerView()

    }

    private fun initRecyclerView() {
        val adapter = UserAdapter()
        binding.userList.adapter = adapter
        viewModel.users.observe(this, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
    }
}