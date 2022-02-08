package com.example.SouhaExam.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashUser(
    val id:String,
    val username:String,
    val first_name:String,
    val last_name:String,

    val profile_image:UnsplashProfileImage): Parcelable