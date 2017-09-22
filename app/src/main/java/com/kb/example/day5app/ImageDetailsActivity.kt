package com.kb.example.day5app

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kb.example.day5app.model.MyImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image_details.*

const val IMAGE_KEY = "com.kb.example.day5app.IMAGE_KEY"

class ImageDetailsActivity : AppCompatActivity() {

    val views: MutableList<View> = mutableListOf()

    companion object {
        fun startActivity(activity: AppCompatActivity, view: View, image: MyImage) {
            val intent = Intent(activity, ImageDetailsActivity::class.java)
            intent.putExtra(IMAGE_KEY, image)
            val options = ActivityOptions.makeSceneTransitionAnimation(activity, view, "image").toBundle()
            activity.startActivity(intent, options)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_details)
        handleExtras(intent.extras)
        addViewsToAnimateAndSetupListeners()
    }

    private fun handleExtras(bundle: Bundle?) {
        val image = bundle?.get(IMAGE_KEY) as MyImage?
        Picasso.with(this).load(image?.imageUrl).into(imageView)
        collapsingToolbar.title = image?.description
    }

    private fun addViewsToAnimateAndSetupListeners() {
        views.add(0, dataLabel)
        views.add(1, categoryLabel)
        views.add(2, authorLabel)
        views.map { it.setOnClickListener { moveToTop(it) } }
    }

    private fun moveToTop(view: View) {

    }
}
