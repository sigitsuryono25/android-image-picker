package com.surelabs.imagepicker.features

import android.content.Intent
import com.surelabs.imagepicker.model.Image

interface ImagePickerInteractionListener {
    fun setTitle(title: String?)
    fun cancel()

    // Get this callback by calling an ImagePickerFragment's finishPickImages() method. It
    // removes Images whose files no longer exist.
    fun finishPickImages(result: Intent?)

    /**
     * Called when the user selects or deselects sn image. Also called in onCreateView.
     * May include Images whose files no longer exist.
     */
    fun selectionChanged(imageList: List<Image>?)
}