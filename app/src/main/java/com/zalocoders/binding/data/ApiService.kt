package com.zalocoders.binding.data

import com.zalocoders.binding.data.model.UserResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getUsers():UserResponse

}