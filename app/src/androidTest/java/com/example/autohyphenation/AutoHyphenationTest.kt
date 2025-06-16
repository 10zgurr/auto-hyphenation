package com.example.autohyphenation

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class AutoHyphenationTest {

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    private val screenshotHelperImpl = ScreenshotHelperImpl()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun saveAutoHyphenationScreenshot() {
        rule.waitUntilAtLeastOneExists(
            hasText("Rechtstesttext hyphen"),
            1000L
        )
        screenshotHelperImpl.takeScreenshot()
        // screenshot will be generated under data/data/com.example.autohyphenation/files/screenshots
        // path from the device explorer
    }
}
