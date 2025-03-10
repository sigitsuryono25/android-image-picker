package com.surelabs.sample

import android.content.Context
import com.surelabs.imagepicker.features.DefaultImagePickerComponents
import com.surelabs.imagepicker.features.imageloader.DefaultImageLoader
import com.surelabs.imagepicker.features.imageloader.ImageLoader

class CustomImagePickerComponents(
    context: Context,
    private val useCustomImageLoader: Boolean
) : DefaultImagePickerComponents(context.applicationContext) {
    override val imageLoader: ImageLoader
        get() = if (useCustomImageLoader) {
            GrayscaleImageLoader()
        } else {
            DefaultImageLoader()
        }
}