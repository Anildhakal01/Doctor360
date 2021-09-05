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

import com.example.doctor360.activity.DoctorRegisterActivity;

import org.junit.Rule;
import org.junit.Test;

public class DoctorRegisterActivityTest {

    @Rule
    public ActivityScenarioRule<DoctorRegisterActivity> activityRule =
            new ActivityScenarioRule<>(DoctorRegisterActivity.class);

    @Test
    public void registerDoctor() {
        onView(withId(R.id.edtDoctorName))
                .perform((typeText("Dr. Ashmin Dhakal")));
        closeSoftKeyboard();
        onView(withId(R.id.edtPatientAddress))
                .perform((typeText("KTM")));
        closeSoftKeyboard();
        onView(withId(R.id.edtDoctorEmail))
                .perform((typeText("ashmindk@gmail.com")));
        closeSoftKeyboard();

        onView(withId(R.id.edtDoctorMobile))
                .perform((typeText("9812625625")));
        closeSoftKeyboard();

        onView(withId(R.id.spinnerDoctorSpecialization)).perform(click());
        onData(anything()).atPosition(2).perform(click());

        onView(withId(R.id.spinnerDoctorGender)).perform(click());
        onData(anything()).atPosition(1).perform(click());

        onView(withId(R.id.spinnerDoctorQualification)).perform(click());
        onData(anything()).atPosition(1).perform(click());

        onView(withId(R.id.edtDoctorPassword))
                .perform((typeText("123456")));
        closeSoftKeyboard();
        closeSoftKeyboard();onView(withId(R.id.edtDoctorConfirmPassword))
                .perform((typeText("123456")));
        closeSoftKeyboard();

        onView(withId(R.id.btnUploadPhoto)).perform(click());
//        savePickedImage()
//        val imgGalleryResult = createImageGallerySetResultStub()
//        intending(hasAction(Intent.ACTION_CHOOSER)).respondWith(imgGalleryResult)
//        onView(withId(R.id.photos_button_gallery)).perform(click())

        //new
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);

//        intended(allOf(hasAction(equalTo(Intent.ACTION_GET_CONTENT)),
//                hasType(is("image/*"))))
        onView(withId(R.id.btnDoctorRegister))
                .perform(click());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        onView(withId(R.id.edtLoginEmail)).check(matches(isDisplayed()));

    }
}