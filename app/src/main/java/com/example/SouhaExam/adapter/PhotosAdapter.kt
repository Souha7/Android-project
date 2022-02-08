package com.example.SouhaExam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.SouhaExam.R
import com.example.SouhaExam.model.UnsplashPhoto
import com.example.SouhaExam.view.PhotoViewHolder
import kotlinx.android.synthetic.main.item_horizontal.view.*

class PhotosAdapter(private val context: Context, private val photos: List<UnsplashPhoto?>) : RecyclerView.Adapter<PhotoViewHolder>() {
    var itemsClickListener:((position:Int, unsplashPhoto:UnsplashPhoto)-> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PhotoViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vertical, parent, false)
        return PhotoViewHolder(view)
    }
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {

        // Getting Element from names list:
        val element = photos[position]
        Glide.with(context)
            .load(element?.urls?.full)
            .into(holder.imageView!!)

        // this element: Updating the text of the txtName
        holder.textViewName?.text = element?.user?.username
        holder.textViewDate?.text = element?.created_at?.take(10)
        holder.itemView.setOnClickListener{
            itemsClickListener?.invoke(position, element!!)
        }


    }
    override fun getItemCount(): Int {
        return photos.size
    }
}