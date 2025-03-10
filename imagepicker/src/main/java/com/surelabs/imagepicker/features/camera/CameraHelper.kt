package com.surelabs.imagepicker.features.camera

import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import android.widget.Toast
import com.surelabs.imagepicker.R

object CameraHelper {
    fun checkCameraAvailability(context: Context): Boolean {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val isAvailable = intent.resolveActivity(context.packageManager) != null
        if (!isAvailable) {
            val appContext = context.applicationContext
            Toast.makeText(
                appContext,
                appContext.getString(R.string.ef_error_no_camera), Toast.LENGTH_LONG
            ).show()
        }
        return isAvailable
    }
}