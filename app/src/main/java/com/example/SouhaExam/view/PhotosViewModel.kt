package com.example.SouhaExam.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.SouhaExam.api.RestInterface
import com.example.SouhaExam.api.RetrofitInstanceUnsplash
import com.example.SouhaExam.model.UnsplashPhoto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query


class PhotosViewModel: ViewModel(){
    //this is the data that we will fetch asynchronously
    private var photoList: MutableLiveData<List<UnsplashPhoto>>? = null
    private var clientId: String ="nJtwNEXeeFzP9aBz_JN9nOHvH3rFUaztyjxqne_Lfdo"
    private var count: Int = 16
    val errorMessage = MutableLiveData<String>()

    fun getRandomPhotos(@Query("client_id") clientId : String, @Query("count") count : Int ): MutableLiveData<List<UnsplashPhoto>>? {

        //if the list is null
        if (photoList == null) {
            photoList = MutableLiveData<List<UnsplashPhoto>>()
            loadPhotos()
        }
        //Final result: The list
        return photoList
    }
    //We are using Retrofit to GET the JSON data from URL:
    private fun loadPhotos() {
        val retIn =
            RetrofitInstanceUnsplash.getRetrofitInstance().create(RestInterface::class.java)
        val response = retIn.getRandomPhotos(clientId,count)
        response?.enqueue(object : Callback<List<UnsplashPhoto>> {
            override fun onResponse(call: Call<List<UnsplashPhoto>>, response:
            Response<List<UnsplashPhoto>>
            ) {
                photoList?.postValue(response.body())
            }
            override fun onFailure(call: Call<List<UnsplashPhoto>>, t: Throwable)
            {
                errorMessage.postValue(t.message)
            }
        })
    }



}