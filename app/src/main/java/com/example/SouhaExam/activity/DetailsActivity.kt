package com.example.SouhaExam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.example.SouhaExam.R
import com.example.SouhaExam.model.UnsplashPhoto
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()!!.hide()
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_details)

        intent = getIntent()
        val urlRegular = intent.getStringExtra("urlRegular")
        val name = intent.getStringExtra("name")
        val profilePhoto = intent.getStringExtra("profilePhoto")
        val description = intent.getStringExtra("description")
        val longDescription = intent.getStringExtra("longDescription")
        val createdAt = intent.getStringExtra("createdAt")
        val updatedAt = intent.getStringExtra("updatedAt")

        Glide.with(this)
                .load(urlRegular)
                .into(imageView!!)
        username_textView.text= name
        Glide.with(this)
            .load(profilePhoto)
            .into(user_imageView!!)
        desc_textView.text= description
        altDesc_textView.text= longDescription

        createdAt_textView.text= createdAt?.take(10)
        updatedAt_textView.text= updatedAt?.take(10)
    }
}