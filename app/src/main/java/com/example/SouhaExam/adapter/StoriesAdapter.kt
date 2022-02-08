package com.example.SouhaExam.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.SouhaExam.R
import com.example.SouhaExam.model.UnsplashPhoto
import com.example.SouhaExam.view.PhotoViewHolder


class StoriesAdapter (private val context: Context, private val photos: List<UnsplashPhoto?>  ) : RecyclerView.Adapter<PhotoViewHolder>() {
    var itemsClickListener:((position:Int, unsplashPhoto:UnsplashPhoto)-> Unit)? = null
    var test: Boolean? = true
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PhotoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horizontal, parent, false)
        return PhotoViewHolder(view)
    }
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {

        // Getting element from names list
        val element = photos[position]
        Glide.with(context)
            .load(element?.user?.profile_image?.small)
            .into(holder.imageView!!)
        test= element?.vue

        // this element :Updating the text of the txtName
        holder.textViewName?.text = element?.user?.username
        holder.itemView.setOnClickListener{
            if(element?.vue==false){
                holder?.cadre?.visibility = View.INVISIBLE
            }
            itemsClickListener?.invoke(position, element!!)
        }
    }
    override fun getItemCount(): Int {
        return photos.size
    }
}