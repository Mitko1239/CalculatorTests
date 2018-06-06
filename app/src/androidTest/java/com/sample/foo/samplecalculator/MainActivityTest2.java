package com.sample.foo.samplecalculator;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static org.junit.Assert.*;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    public void clickSpecificButton(){
        ViewInteraction button4 = onView(
                allOf(withId(R.id.buttonSeven), withText("4"), isDisplayed()));
        button4.perform(click());
    }

    public void clickButton(String buttonText){
        ViewInteraction button4 = onView(
                allOf(withText(buttonText), isDisplayed()));
        button4.perform(click());
    }

    public void checkElementText(int id, String text){
        ViewInteraction resultView = onView(withId(id));
        resultView.check(matches(withText(text)));
    }

    @Test
    public void mainActivityTest2() {
        clickButton("4");
        clickButton("+");
        clickButton("5");
        clickButton("=");
        checkElementText(R.id.infoTextView, "4+5 = 9");
    }

}
