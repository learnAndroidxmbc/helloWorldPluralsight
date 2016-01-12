package com.sqisland.android.hello;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.action.ViewActions.click;

/**
 * Created by ernie on 1/12/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<> (MainActivity.class);

    @Test
    public void bye() {

        //  check if the   R.id.greeting  matches with  Hello World
        ViewInteraction check = onView(withId(R.id.greeting))
                .check(matches(withText(R.string.hello_world)));

        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText(R.string.say_bye))
                .perform(click());

        onView(withId(R.id.action_bye))
            .check(matches(withText(R.string.hello_world)));
    }
}

