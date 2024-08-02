package com.example.recyclerviewsample

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val articleArrayList: List<Article>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    private lateinit var myListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClicking(position: Int)
    }

    fun setOnItemClickListener(listener : OnItemClickListener){
        myListener = listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newsitem, parent, false)
        return MyViewHolder(view,myListener)
    }

    override fun getItemCount(): Int {
        return articleArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = articleArrayList[position]
        holder.hTitle.text = currentItem.title
        if (currentItem.urlToImage != null){
            Picasso.get().load(currentItem.urlToImage).into(holder.hImage)
        }else{
            holder.hImage.setImageResource(R.drawable.img)
        }

    }

    class MyViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val hTitle: TextView
        val hImage: ShapeableImageView

        init {
             hTitle  = itemView.findViewById(R.id.headingTitle)
             hImage = itemView.findViewById(R.id.headingImage)

            itemView.setOnClickListener {
                listener.onItemClicking(adapterPosition)
            }

        }
    }
}