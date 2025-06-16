package com.example.autohyphenation

internal class ScreenshotHelperImpl : ScreenshotHelper() {

    override fun getScreenshotFileName(): String =
        "screenshot_robolectric.png"

    override fun getScreenshotFolderName(): String =
        "build/outputs/screenshots"
}
