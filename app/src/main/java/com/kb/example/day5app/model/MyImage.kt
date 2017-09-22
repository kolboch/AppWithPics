package com.kb.example.day5app.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Karol on 2017-09-22.
 */
@Parcelize
data class MyImage(val imageUrl: String, val description: String) : Parcelable