package com.surelabs.imagepicker.helper

import androidx.core.content.FileProvider
import com.surelabs.imagepicker.features.DefaultImagePickerComponents
import com.surelabs.imagepicker.features.ImagePickerComponentsHolder

class ImagePickerFileProvider : FileProvider() {
    override fun onCreate(): Boolean {
        ImagePickerComponentsHolder.setInternalComponent(DefaultImagePickerComponents(context!!))
        return super.onCreate()
    }
}