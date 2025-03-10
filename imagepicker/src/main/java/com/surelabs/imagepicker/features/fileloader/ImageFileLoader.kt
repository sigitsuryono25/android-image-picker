package com.surelabs.imagepicker.features.fileloader

import com.surelabs.imagepicker.features.ImagePickerConfig
import com.surelabs.imagepicker.features.common.ImageLoaderListener

interface ImageFileLoader {
    fun loadDeviceImages(config: ImagePickerConfig, listener: ImageLoaderListener)
    fun abortLoadImages()
}