package com.zalocoders.binding.Repository

import androidx.lifecycle.ViewModel
import com.zalocoders.binding.data.ApiService
import com.zalocoders.binding.data.model.UserResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApiService: ApiService){

    suspend fun getUsers(): Flow<UserResponse> {
        return flow {
            delay(500)
            val userResponse = userApiService.getUsers()
            emit(userResponse)
        }
    }
}
