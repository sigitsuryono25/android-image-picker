package com.surelabs.imagepicker.features.common

import com.surelabs.imagepicker.features.ImagePickerSavePath
import com.surelabs.imagepicker.features.ReturnMode

abstract class BaseConfig {
    abstract var savePath: ImagePickerSavePath
    abstract var returnMode: ReturnMode
    abstract var isSaveImage: Boolean
}