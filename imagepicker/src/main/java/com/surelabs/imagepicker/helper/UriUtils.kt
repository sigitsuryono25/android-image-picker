package com.surelabs.imagepicker.helper

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import java.util.Locale

object UriUtils {
    fun uriForFile(context: Context, file: File): Uri {
        val appContext = context.applicationContext
        val providerName = String.format(Locale.ENGLISH, "%s%s", appContext.packageName, ".imagepicker.provider")
        return FileProvider.getUriForFile(appContext, providerName, file)
    }
}