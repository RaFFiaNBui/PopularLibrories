package com.example.lesson7;

import androidx.test.rule.ActivityTestRule;

import com.example.lesson7.espresso.EspressoActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MyEspressoTest {

    @Rule
    public ActivityTestRule<EspressoActivity> activityTestRule = new ActivityTestRule<>(EspressoActivity.class);

    @Test
    public void onClick() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText(R.string.hello)));
    }
}
