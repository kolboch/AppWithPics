package com.kb.example.day5app

import com.kb.example.day5app.model.MyImage

/**
 * Created by Karol on 2017-09-22.
 */

const val BASE_URL = "https://unsplash.it/500/500?image="

class ImageProvider {

    companion object {
        fun provideImages(): List<MyImage> {
            var images: MutableList<MyImage> = mutableListOf()
            (40..55).mapTo(images) { MyImage(BASE_URL + it, "Demo title") }
            return images
        }
    }
}