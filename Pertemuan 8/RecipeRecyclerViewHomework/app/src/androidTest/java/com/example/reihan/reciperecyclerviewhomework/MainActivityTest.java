package com.example.reihan.reciperecyclerviewhomework;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recyclerview),
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.recipe_image),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.recipe_details), withText("Ingredients \n 2 tablespoons soy sauce \n 1 tablespoon sesame oil \n 1 tablespoon grated fresh ginger \n 1 teaspoon minced garlic \n 3/4 pound pork tenderloin, fat trimmed and pork cut into 1/4-inch strips \n 2 tablespoons vegetable oil \n 2 cups shredded napa cabbage \n 1 carrot, grated \n salt and ground black pepper to taste \n\n Directions \n 1. Mix soy sauce, sesame oil, ginger, and garlic in a bowl until marinade is smooth; pour into a resealable plastic bag. Add pork, coat with the marinade, squeeze out excess air, and seal the bag. Marinate in the refrigerator, 1 hour to overnight \n 2. Heat vegetable oil in a wok or large skillet over medium heat. Add cabbage and carrot; cook and stir for 1 to 2 minutes. Push cabbage mixture aside and add pork with marinade to middle of the skillet. Cook and stir until pork is cooked through, 3 to 4 minutes. Draw cabbage into the center of the skillet; cook and stir for 1 to 2 minutes. Season with salt and pepper. "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("Ingredients   2 tablespoons soy sauce   1 tablespoon sesame oil   1 tablespoon grated fresh ginger   1 teaspoon minced garlic   3/4 pound pork tenderloin, fat trimmed and pork cut into 1/4-inch strips   2 tablespoons vegetable oil   2 cups shredded napa cabbage   1 carrot, grated   salt and ground black pepper to taste    Directions   1. Mix soy sauce, sesame oil, ginger, and garlic in a bowl until marinade is smooth; pour into a resealable plastic bag. Add pork, coat with the marinade, squeeze out excess air, and seal the bag. Marinate in the refrigerator, 1 hour to overnight   2. Heat vegetable oil in a wok or large skillet over medium heat. Add cabbage and carrot; cook and stir for 1 to 2 minutes. Push cabbage mixture aside and add pork with marinade to middle of the skillet. Cook and stir until pork is cooked through, 3 to 4 minutes. Draw cabbage into the center of the skillet; cook and stir for 1 to 2 minutes. Season with salt and pepper. ")));

        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
