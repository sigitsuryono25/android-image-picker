package com.surelabs.imagepicker.features

import android.content.Intent
import com.surelabs.imagepicker.features.cameraonly.ImagePickerCameraOnly
import com.surelabs.imagepicker.model.Image

object ImagePicker {
    fun cameraOnly(): ImagePickerCameraOnly {
        return ImagePickerCameraOnly()
    }

    /* --------------------------------------------------- */
    /* > Helper */
    /* --------------------------------------------------- */

    @Deprecated("This method will marked internal soon. Please use the new API")
    fun getImages(intent: Intent?): List<Image>? {
        return intent?.getParcelableArrayListExtra(IpCons.EXTRA_SELECTED_IMAGES)
    }
}