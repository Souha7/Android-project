package com.example.SouhaExam.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.SouhaExam.R
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.item_horizontal.view.*

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView? = itemView.findViewById(R.id.imageView)
    var textViewName: TextView? = itemView.findViewById(R.id.textViewName)
    var textViewDate: TextView? = itemView.findViewById(R.id.textViewDate)
    var cadre: MaterialCardView? = itemView.cadre


}