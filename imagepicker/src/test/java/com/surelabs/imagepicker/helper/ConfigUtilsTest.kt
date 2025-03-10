package com.surelabs.imagepicker.helper

import com.surelabs.imagepicker.features.ImagePickerConfig
import com.surelabs.imagepicker.features.ReturnMode
import com.surelabs.imagepicker.features.cameraonly.CameraOnlyConfig
import com.surelabs.imagepicker.shouldBe
import org.junit.jupiter.api.Test

class ConfigUtilsTest {

    @Test
    fun `camera action return mode should be valid`() {
        val cameraConfig = CameraOnlyConfig()
        ConfigUtils.shouldReturn(cameraConfig, true) shouldBe true

        val config = ImagePickerConfig(
            returnMode = ReturnMode.CAMERA_ONLY
        )
        ConfigUtils.shouldReturn(config, true) shouldBe true
        ConfigUtils.shouldReturn(config, false) shouldBe false
    }
}