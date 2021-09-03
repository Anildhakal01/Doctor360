package com.example.doctor360;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import com.example.doctor360.activity.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PatientLoginTest {
    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void PatientLogin() {
        onView(withId(R.id.spinnerUserType)).perform(click());
        onData(anything()).atPosition(1).perform(click());

        onView(withId(R.id.edtLoginEmail))
                .perform((typeText("shalik@gmail.com")));
        closeSoftKeyboard();
        onView(withId(R.id.edtLoginPassword))
                .perform((typeText("123456")));
        closeSoftKeyboard();

        onView(withId(R.id.btnLogin))
                .perform(click());
    }
}
