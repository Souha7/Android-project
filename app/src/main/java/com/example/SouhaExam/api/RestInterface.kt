package com.example.SouhaExam.api

import com.example.SouhaExam.model.UnsplashPhoto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestInterface {

    @GET("photos/random")
    fun getRandomPhotos(@Query("client_id") clientId : String, @Query("count") count : Int ): Call<List<UnsplashPhoto>>
    @GET("photos/{id}")
    fun getPhotoById(@Path("id") id : String, @Query("client_id") clientId : String): Call<UnsplashPhoto>
}