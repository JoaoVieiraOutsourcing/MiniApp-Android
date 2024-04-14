package com.example.miniapp

import android.content.Intent
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.miniapp", appContext.packageName)
    }

    @Test
    fun testIntentCreation() {

        val email = "abc@gmail.com"
        val subject = "Test"
        val content = "Test Contents"

        val expectedIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, email)
            putExtra(Intent.EXTRA_TEXT, "To: " + email + "\nSubject: " + subject + "\n" + content)
        }

        val actualIntent = shareEmailTest(email, subject, content)

        assertEquals(expectedIntent, actualIntent)

    }
}