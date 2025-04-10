package com.example.android.testing.espresso.BasicSample

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    @JvmField
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private fun enterText(input: String) {
        Espresso.onView(withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(input), ViewActions.closeSoftKeyboard())
    }

    @Test
    fun testChangeText_with123Input() {
        enterText("123")
        Espresso.onView(withId(R.id.changeTextBt)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("123")))
    }

    @Test
    fun testChangeText_withEmptyInput() {
        enterText("")
        Espresso.onView(withId(R.id.changeTextBt)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    @Test
    fun testChangeText_withAbcdefInput() {
        enterText("abcdef")
        Espresso.onView(withId(R.id.changeTextBt)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("abcdef")))
    }

    @Test
    fun testOpenActivity_with123Input() {
        enterText("123")
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.show_text_view))
            .check(ViewAssertions.matches(ViewMatchers.withText("123")))
    }

    @Test
    fun testOpenActivity_withEmptyInput() {
        enterText("")
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.show_text_view))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    @Test
    fun testOpenActivity_withNoInput() {
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.show_text_view))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    @Test
    fun testOpenActivity_withAbcdefInput() {
        enterText("abcdef")
        Espresso.onView(withId(R.id.activityChangeTextBtn)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.show_text_view))
            .check(ViewAssertions.matches(ViewMatchers.withText("abcdef")))
    }
}
