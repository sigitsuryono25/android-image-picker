package com.surelabs.imagepicker.helper

import android.content.Context
import android.preference.PreferenceManager
import androidx.core.content.edit

class ImagePickerPreferences(context: Context) {

    companion object {
        private const val KEY_PERMISSION_GRANTED = "Key.WritePermissionGranted"
    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    /**
     * Set a permission is requested
     */
    fun setPermissionIsRequested() {
        preferences.edit {
            putBoolean(KEY_PERMISSION_GRANTED, true)
        }
    }

    /**
     * Check if a permission is requested or not (false by default)
     */
    fun isPermissionRequested(): Boolean {
        return preferences.getBoolean(KEY_PERMISSION_GRANTED, false)
    }
}