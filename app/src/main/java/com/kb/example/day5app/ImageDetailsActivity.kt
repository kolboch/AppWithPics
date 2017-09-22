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


    companion object {
        fun startActivity(activity: AppCompatActivity, view: View, image: MyImage) {
            val intent = Intent(activity, ImageDetailsActivity::class.java)
            intent.putExtra(IMAGE_KEY, image)
            val options = ActivityOptions.makeSceneTransitionAnimation(activity, view, "image").toBundle()
//            val constraintSet = ConstraintSet()
//            constraintSet.clone(activity.applicationContext, R.layout.activity_image_details)
//            TransitionManager.beginDelayedTransition(activity.constraintParent)
//            constraintSet.applyTo(activity.constraintParent)
            activity.startActivity(intent, options)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_details)
        handleExtras(intent.extras)
    }

    private fun handleExtras(bundle: Bundle?) {
        val image = bundle?.get(IMAGE_KEY) as MyImage?
        Picasso.with(this).load(image?.imageUrl).into(imageView)
    }
}
