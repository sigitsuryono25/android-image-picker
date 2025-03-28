package com.surelabs.sample


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn
import com.surelabs.sample.utils.Rules
import com.surelabs.sample.utils.ViewAsserts
import com.surelabs.sample.utils.Views
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CustomUiTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Rule
    @JvmField
    val grantPermissionRule = Rules.AIP_PERMISSIONS

    @Test
    fun cameraOnlyTestTwo() {
        clickOn(R.id.button_custom_ui)

        val recyclerView = Views.recyclersView()
        recyclerView.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))

        // Click done button
        val actionMenuItemView = Views.pickerDoneButton()
        actionMenuItemView.perform(ViewActions.click())

        // Check if image is picked
        Views.waitFor(500)
        clickOn(R.id.text_view)

        val imageView = Views.imageDetail()
        ViewAsserts.imagePicked(imageView)
    }
}
