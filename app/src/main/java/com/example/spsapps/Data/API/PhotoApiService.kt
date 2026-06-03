package com.example.spsapps.Data.API

import com.example.spsapps.Data.Model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}