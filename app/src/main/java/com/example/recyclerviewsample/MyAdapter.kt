package com.example.recyclerviewsample

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val newArrayList: ArrayList<News>, val context: Activity) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var myListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClicking(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newsitem, parent, false)
        return MyViewHolder(view,myListener)
    }

    override fun getItemCount(): Int {
        return newArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newArrayList[position]
        holder.hTitle.text = currentItem.heading
        holder.hImage.setImageResource(currentItem.newsImage)
    }

    class MyViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val hTitle  = itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

        init {
            itemView.setOnClickListener{
                listener.onItemClicking(adapterPosition)
            }
        }
    }
}