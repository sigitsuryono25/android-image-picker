package com.surelabs.imagepicker.features.common

import com.surelabs.imagepicker.model.Folder
import com.surelabs.imagepicker.model.Image

interface ImageLoaderListener {
    fun onImageLoaded(images: List<Image>, folders: List<Folder>)
    fun onFailed(throwable: Throwable)
}