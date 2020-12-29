package com.zalocoders.binding.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zalocoders.binding.Repository.UserRepository
import com.zalocoders.binding.data.model.UserResponse
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel @ViewModelInject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val userMutableLiveData = MutableLiveData<UserResponse>()

    val users: LiveData<UserResponse>
        get() = userMutableLiveData


     fun getUsers() {
        viewModelScope.launch {
            repository.getUsers()
                .collect {
                    userMutableLiveData.value = it
                }
        }
    }
}