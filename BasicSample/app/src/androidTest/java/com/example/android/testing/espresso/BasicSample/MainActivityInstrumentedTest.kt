package com.example.android.testing.espresso.BasicSample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityInstrumentedTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    private fun enterText(input: String) {
        onView(withId(R.id.editTextUserInput))
            .perform(replaceText(input), closeSoftKeyboard())
    }

    @Test
    fun testChangeText_with123Input() {
        enterText("123")
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("123")))
    }

    @Test
    fun testChangeText_withEmptyInput() {
        enterText("")
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged))
            .check(matches(withText("")))
    }

    //here

}
