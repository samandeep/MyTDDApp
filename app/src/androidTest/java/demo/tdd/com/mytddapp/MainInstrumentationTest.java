package demo.tdd.com.mytddapp;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Samandeep Kaur Sidhu on 25/09/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainInstrumentationTest {


    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test_user_login() throws Exception {
        onView(withId(R.id.etEmail)).perform(typeText("7408086946"), closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText("Test@1234"), closeSoftKeyboard());
        onView(withId(R.id.btSignIn)).perform(click());
        Thread.sleep(4000);
        onView(withId(R.id.tvWelcome)).check(matches(isDisplayed()));
    }
}
