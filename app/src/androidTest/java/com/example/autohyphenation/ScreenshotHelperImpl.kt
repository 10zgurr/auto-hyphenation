package com.example.autohyphenation

import androidx.test.platform.app.InstrumentationRegistry

internal class ScreenshotHelperImpl : ScreenshotHelper() {

    private val context = InstrumentationRegistry
        .getInstrumentation()
        .targetContext

    override fun getScreenshotFileName(): String =
        "screenshot_instrumented.png"

    override fun getScreenshotFolderName(): String =
        "${context.filesDir}/$SCREENSHOT_FOLDER_NAME"
}

private const val SCREENSHOT_FOLDER_NAME = "screenshots"
