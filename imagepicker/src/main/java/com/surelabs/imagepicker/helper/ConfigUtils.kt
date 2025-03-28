package com.surelabs.imagepicker.helper

import android.content.Context
import com.surelabs.imagepicker.R
import com.surelabs.imagepicker.features.ImagePickerConfig
import com.surelabs.imagepicker.features.ImagePickerMode
import com.surelabs.imagepicker.features.ReturnMode
import com.surelabs.imagepicker.features.cameraonly.CameraOnlyConfig
import com.surelabs.imagepicker.features.common.BaseConfig

object ConfigUtils {
    fun checkConfig(config: ImagePickerConfig): ImagePickerConfig {
        check(!(config.mode != ImagePickerMode.SINGLE
            && (config.returnMode === ReturnMode.GALLERY_ONLY
            || config.returnMode === ReturnMode.ALL))) { "ReturnMode.GALLERY_ONLY and ReturnMode.ALL is only applicable in Single Mode!" }
        return config
    }

    fun shouldReturn(config: BaseConfig, isCamera: Boolean): Boolean {
        if (config is CameraOnlyConfig) return true
        val mode = config.returnMode
        return if (isCamera) {
            mode === ReturnMode.ALL || mode === ReturnMode.CAMERA_ONLY
        } else {
            mode === ReturnMode.ALL || mode === ReturnMode.GALLERY_ONLY
        }
    }

    fun getFolderTitle(context: Context, config: ImagePickerConfig): String {
        val folderTitle = config.folderTitle
        return if (folderTitle.isNullOrBlank()) context.getString(R.string.ef_title_folder) else folderTitle
    }

    fun getImageTitle(context: Context, config: ImagePickerConfig): String {
        val configImageTitle = config.imageTitle
        return if (configImageTitle.isNullOrBlank()) context.getString(R.string.ef_title_select_image) else configImageTitle
    }

    fun getDoneButtonText(context: Context, config: ImagePickerConfig): String {
        val doneButtonText = config.doneButtonText
        return if (doneButtonText.isNullOrBlank()) context.getString(R.string.ef_done) else doneButtonText
    }
}