package com.surelabs.sample


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.adevinta.android.barista.intents.BaristaIntents.mockAndroidCamera
import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn
import com.adevinta.android.barista.interaction.BaristaMenuClickInteractions
import com.surelabs.sample.utils.Rules
import com.surelabs.sample.utils.ViewAsserts
import com.surelabs.sample.utils.Views
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CameraOnPickerTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Rule
    @JvmField
    val grantPermissionRule = Rules.AIP_PERMISSIONS

    private fun callCamera() {
        Intents.init()
        mockAndroidCamera()
        BaristaMenuClickInteractions.clickMenu(R.id.menu_camera)
        Intents.release()
    }

    private fun assertImagePicked() {
        Views.waitFor(1_000)
        clickOn(R.id.text_view)

        val imageView = Views.imageDetail()
        ViewAsserts.imagePicked(imageView)
    }

    @Test
    fun cameraWithoutReturnAfterCapture() {
        clickOn(R.id.switch_single)

        // Go into picker
        Views.pickImageButton().perform(click())

        // Go into camera
        callCamera()

        // Pick first image (camera image)
        val rv = Views.recyclersView()
        rv.perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        // Done
        BaristaMenuClickInteractions.clickMenu(R.id.menu_done)

        assertImagePicked()
    }

    @Test
    fun cameraWithReturnAfterCapture() {
        clickOn(R.id.switch_return_after_capture)
        clickOn(R.id.switch_single)

        // Go into picker
        Views.pickImageButton().perform(click())

        // Go into camera
        callCamera()

        assertImagePicked()
    }
}
