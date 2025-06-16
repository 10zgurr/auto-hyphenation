package com.example.autohyphenation

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import org.robolectric.annotation.GraphicsMode.Mode.NATIVE

@RunWith(RobolectricTestRunner::class)

@GraphicsMode(NATIVE)
// Pixel8 device qualifier is being used here
@Config(qualifiers = "w411dp-h914dp-xxhdpi", sdk = [34])
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
        // screenshot will be generated under app/build/outputs/screenshots path
    }
}
