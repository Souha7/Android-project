
package com.example.SouhaExam.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.SouhaExam.adapter.PhotosAdapter
import com.example.SouhaExam.view.PhotosViewModel
import com.example.SouhaExam.R
import com.example.SouhaExam.adapter.StoriesAdapter
import com.example.SouhaExam.model.UnsplashPhoto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var photosAdapter: PhotosAdapter
    lateinit var storiesAdapter: StoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()!!.hide()
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        listRecyclerViewV.setHasFixedSize(true)
        listRecyclerViewH.setHasFixedSize(true)
        listRecyclerViewH.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        listRecyclerViewV.layoutManager = GridLayoutManager(this,2)

        val viewModel: PhotosViewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)
        viewModel.getRandomPhotos("qxBztNhYxJwakNiu8hX2fcyc_-clCX-aY2TslXTIT3I",16)?.observe(
            this,
            object : Observer<List<UnsplashPhoto?>?> {
                override fun onChanged(@Nullable photoList: List<UnsplashPhoto?>?) {
                     photosAdapter = PhotosAdapter(this@MainActivity, photoList!!)
                     storiesAdapter = StoriesAdapter(this@MainActivity, photoList!!)
                    listRecyclerViewH.adapter = storiesAdapter
                    listRecyclerViewV.adapter = photosAdapter
                    setDetailsAdapterListener()
                    setStoriesAdapterListener()
                }
            })

    }
    fun setDetailsAdapterListener(){
        photosAdapter.itemsClickListener ={
            position, element ->
            val intent = Intent( this,DetailsActivity::class.java)
            intent.putExtra("urlRegular", element.urls.regular)
            intent.putExtra("name", element.user.username)
            intent.putExtra("profilePhoto", element.user.profile_image.small)
            intent.putExtra("description", element.description)
            intent.putExtra("longDescription", element.alt_description)
            intent.putExtra("createdAt", element.created_at)
            intent.putExtra("updatedAt", element.updated_at)
            startActivity(intent)
        }

    }
    fun setStoriesAdapterListener(){

        storiesAdapter.itemsClickListener ={
            position, element ->
            val intent = Intent( this,StoryActivity::class.java)
            intent.putExtra("urlFull", element.urls.full)
            intent.putExtra("name", element.user.username)
            intent.putExtra("profilePhoto", element.user.profile_image.small)
            startActivity(intent)

        }

    }
}