package com.surelabs.imagepicker.listeners

import com.surelabs.imagepicker.model.Folder
import com.surelabs.imagepicker.model.Image

typealias OnImageClickListener = (Boolean) -> Boolean
typealias OnFolderClickListener = (Folder) -> Unit
typealias OnImageSelectedListener = (List<Image>) -> Unit
