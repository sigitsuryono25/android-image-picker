package com.surelabs.imagepicker.features.imageloader

import android.widget.ImageView
import com.surelabs.imagepicker.model.Image

interface ImageLoader {
    fun loadImage(image: Image, imageView: ImageView, imageType: ImageType)
}