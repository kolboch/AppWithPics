package com.kb.example.day5app.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import com.kb.example.day5app.model.MyImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by Karol on 2017-09-22.
 */
class MyImageHolder(itemView: View, private val callback: (View, MyImage) -> Unit) : RecyclerView.ViewHolder(itemView) {

    fun bindView(image: MyImage) {
        Picasso.with(itemView.context).load(image.imageUrl).into(itemView.image)
        itemView.imageTitle.text = image.description
        itemView.setOnClickListener {
            callback(itemView, image)
        }
    }

}