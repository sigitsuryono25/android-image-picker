package com.surelabs.imagepicker.features.cameraonly

import android.os.Parcelable
import com.surelabs.imagepicker.features.ImagePickerSavePath
import com.surelabs.imagepicker.features.ReturnMode
import com.surelabs.imagepicker.features.common.BaseConfig
import kotlinx.parcelize.Parcelize

@Parcelize
class CameraOnlyConfig(
    override var savePath: ImagePickerSavePath = ImagePickerSavePath.DEFAULT,
    override var returnMode: ReturnMode = ReturnMode.ALL,
    override var isSaveImage: Boolean = true
) : BaseConfig(), Parcelable