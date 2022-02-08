package com.example.SouhaExam.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashPhoto(
    val id:String,
    val urls: UnsplashPhotoUrls,
    val created_at:String,
    val updated_at:String,
    val description:String,
    val alt_description:String,
    val user:UnsplashUser,
    var vue: Boolean = false): Parcelable
