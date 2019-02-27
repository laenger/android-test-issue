package biz.laenger.android.foo.app

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import biz.laenger.android.foo.app.presentation.main.MainActivity
import org.junit.Rule
import org.junit.runner.RunWith
import kotlin.test.Test

@RunWith(AndroidJUnit4::class)
@LargeTest
class FooTest {

    @get:Rule val activityRule: ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Test
    fun testFoo() {
        // this one fails
        activityRule.launchActivity(null)
    }

}
