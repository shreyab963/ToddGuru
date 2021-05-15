package com.example.toddlerteacher;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static java.util.regex.Pattern.matches;

@RunWith(AndroidJUnit4.class)
@LargeTest


public class RegisterUserTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void check_button() {
        onView(withId(R.id.registerUser));

    }

}