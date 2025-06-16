package com.example.autohyphenation

import android.graphics.Bitmap
import androidx.test.platform.app.InstrumentationRegistry
import java.io.File
import java.io.FileOutputStream

abstract class ScreenshotHelper {

    fun takeScreenshot() {
        saveScreenshot(captureToBitmap())
    }

    abstract fun getScreenshotFileName(): String

    abstract fun getScreenshotFolderName(): String

    private fun captureToBitmap(): Bitmap =
        InstrumentationRegistry.getInstrumentation()
            .uiAutomation
            .takeScreenshot()

    private fun saveScreenshot(bitmap: Bitmap) {
        val screenshotsDir = File(getScreenshotFolderName())
        if (screenshotsDir.exists()) {
            screenshotsDir.delete()
        }
        screenshotsDir.mkdirs()
        val screenshot = File(screenshotsDir, getScreenshotFileName())
        FileOutputStream(screenshot)
            .use { output ->
                bitmap
                    .compress(
                        Bitmap.CompressFormat.PNG,
                        SCREENSHOT_QUALITY_PERCENTAGE,
                        output,
                    )
            }
    }
}

private const val SCREENSHOT_QUALITY_PERCENTAGE = 100
