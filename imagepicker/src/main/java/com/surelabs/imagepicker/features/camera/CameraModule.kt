package com.surelabs.imagepicker.features.camera

import android.content.Context
import android.content.Intent
import com.surelabs.imagepicker.features.common.BaseConfig
import com.surelabs.imagepicker.model.Image

typealias OnImageReadyListener = (List<Image>?) -> Unit

interface CameraModule {
    fun getCameraIntent(context: Context, config: BaseConfig): Intent?
    fun getImage(context: Context, intent: Intent?, imageReadyListener: OnImageReadyListener)
    fun removeImage(context: Context)
}