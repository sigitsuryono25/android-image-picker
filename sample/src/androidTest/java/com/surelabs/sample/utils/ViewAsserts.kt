package com.surelabs.sample.utils

import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.surelabs.sample.matchers.hasDrawable

object ViewAsserts {
    fun imagePicked(imageView: ViewInteraction) {
        imageView.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        imageView.check(ViewAssertions.matches(hasDrawable()))
    }
}