package com.example.toddlerteacher;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class LoginTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void check_button() {
        onView(withId(R.id.login));
        onView(withId(R.id.registerUser));
        onView(withId(R.id.logout));

    }

}