package com.kb.example.day5app.recycler

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kb.example.day5app.R
import com.kb.example.day5app.model.MyImage

/**
 * Created by Karol on 2017-09-22.
 */
class MyPhotoRecyclerAdapter(private val callback: (View, MyImage) -> Unit) : RecyclerView.Adapter<MyImageHolder>() {

    var images: List<MyImage> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyImageHolder {
        val imageView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyImageHolder(imageView, callback)
    }

    override fun onBindViewHolder(holder: MyImageHolder, position: Int) {
        holder.bindView(images[position])
        Log.v("recycler", images[position].toString())
    }

    override fun getItemCount() = images.size


}