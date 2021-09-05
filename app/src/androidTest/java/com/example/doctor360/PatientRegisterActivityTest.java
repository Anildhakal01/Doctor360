package com.example.doctor360;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import com.example.doctor360.activity.PatientRegisterActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PatientRegisterActivityTest {

    @Rule
    public ActivityScenarioRule<PatientRegisterActivity> activityRule =
            new ActivityScenarioRule<>(PatientRegisterActivity.class);
    @Test
    public void registerPatient() {
        onView(withId(R.id.edtPatientName))
                .perform((typeText("Shalik Dhakal")));
        closeSoftKeyboard();
        onView(withId(R.id.edtPatientAddress))
                .perform((typeText("KTM")));
        closeSoftKeyboard();
        onView(withId(R.id.edtPatientEmail))
                .perform((typeText("shalik11@gmail.com")));
        closeSoftKeyboard();

        onView(withId(R.id.edtPatientMobile))
                .perform((typeText("9811625625")));
        closeSoftKeyboard();

        onView(withId(R.id.spinnerPatientAge)).perform(click());

        onData(anything()).atPosition(19).perform(click());
        onView(withId(R.id.spinnerPatientGender)).perform(click());
        onData(anything()).atPosition(0).perform(click());

        onView(withId(R.id.spinnerPatientBlood)).perform(click());
        onData(anything()).atPosition(0).perform(click());

        onView(withId(R.id.edtPatientPassword))
                .perform((typeText("123456")));
        closeSoftKeyboard();
        closeSoftKeyboard();onView(withId(R.id.edtPatientConfirmPassword))
                .perform((typeText("123456")));
        closeSoftKeyboard();

        onView(withId(R.id.buttonPatientRegister))
                .perform(click());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.loginPatientText)).perform(click());

        onView(withId(R.id.edtLoginEmail)).check(matches(isDisplayed()));
    }
}
