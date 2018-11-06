package com.tistory.black_jin0427.myandroidarchitecture;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.view.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;



@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainTestActivity {

    @Rule
    public ActivityTestRule<MainActivity>  mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkRecyclerView() throws Exception {

        //'com.android.support.test.espresso:espresso-contrib:3.0.2'
        Espresso.onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        Espresso.pressBack();

        Espresso.onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        Espresso.pressBack();

        Espresso.onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));

    }
}
