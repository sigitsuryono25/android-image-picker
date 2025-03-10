package com.surelabs.imagepicker.helper

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.FragmentActivity
import com.surelabs.imagepicker.R

object ViewUtils {
    fun getArrowIcon(context: Context): Drawable? {
        val backResourceId: Int =
            if (context.resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                // For right-to-left layouts, pick the drawable that points to the right (forward).
                R.drawable.ef_ic_arrow_forward
            } else {
                // For left-to-right layouts, pick the drawable that points to the left (back).
                R.drawable.ef_ic_arrow_back
            }
        return ContextCompat.getDrawable(context.applicationContext, backResourceId)
    }

    fun FragmentActivity.setInsets(root: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            root.setOnApplyWindowInsetsListener { view, windowInsets ->
                val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
                val bottomInsets = windowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())
                view.updatePadding(top = insets.top, bottom = bottomInsets.bottom)
                WindowInsets.CONSUMED
            }
            root.setBackgroundColor(R.attr.colorPrimary)
        } else {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = R.attr.colorPrimary
        }
    }
}
