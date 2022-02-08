package com.example.SouhaExam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.example.SouhaExam.R
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_story.*

class StoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()!!.hide()
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_story)

        intent = getIntent()
        val urlFull = intent.getStringExtra("urlFull")
        val name = intent.getStringExtra("name")
        val profilePhoto = intent.getStringExtra("profilePhoto")
        Glide.with(this)
            .load(urlFull)
            .into(useIimageView!!)
    }
}