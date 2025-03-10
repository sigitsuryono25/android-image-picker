package com.surelabs.imagepicker.features

/**
 * Define the ImagePicker return behaviour
 * NONE -> When image is picked, [ImagePickerActivity] will not be dismissed even in [ImagePickerMode.SINGLE]
 * ALL -> When image is picked dismiss then deliver result
 * CAMERA_ONLY -> When image is picked with Camera, dismiss then deliver the result
 * GALLERY_ONLY -> Same as CAMERA_ONLY but with Gallery
 */
enum class ReturnMode {
    NONE, ALL, CAMERA_ONLY, GALLERY_ONLY
}