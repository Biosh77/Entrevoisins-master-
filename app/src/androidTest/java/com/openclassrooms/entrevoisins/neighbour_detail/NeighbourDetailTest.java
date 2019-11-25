package com.openclassrooms.entrevoisins.neighbour_detail;


import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import static android.support.test.espresso.Espresso.onView;

import com.openclassrooms.entrevoisins.R;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator;

import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourFragment;
import com.openclassrooms.entrevoisins.utils.RecyclerViewUtils;



import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.List;

import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewUtils.atPosition;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewUtils.clickChildView;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)

public class NeighbourDetailTest {

    private ListNeighbourActivity mActivity;
    private static int ITEMS_COUNT =  DummyNeighbourGenerator.DUMMY_NEIGHBOURS.size();




    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule = new ActivityTestRule(ListNeighbourActivity.class);




    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());

        }


    @Test
    public void showDetailNeighbourWithSuccess(){

        onView(allOf(withId(R.id.list_neighbours)
                ,isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.WhiteName)).check(matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void showDetailNameWithSuccess(){

        onView(allOf(withId(R.id.list_neighbours)
                ,isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        String expectedName = DummyNeighbourGenerator.DUMMY_NEIGHBOURS.get(0).getName();
        onView(withId(R.id.Name)).check(matches(withText(expectedName)));
    }


    @Test
    public void checkIfRemovingUserIsWorking() {
        onView(allOf(withId(R.id.list_neighbours)
                ,isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(1,
                        clickChildView(R.id.item_list_delete_button)));
        onView(allOf(withId(R.id.list_neighbours)
                ,isDisplayed())).check(new RecyclerViewUtils.ItemCount(   ITEMS_COUNT - 1));
    }


    @Test
    public void showFavoriteInTab() {


        onView(allOf(withId(R.id.list_neighbours)
                ,isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.Favorite)).perform(click());
        pressBack();
        onView(withText(R.string.tab_favorites_title)).perform(click()); // onglet favo
        NeighbourFragment currentFragment = (NeighbourFragment) mActivity.getSupportFragmentManager().findFragmentById(R.id.container);
        List<Neighbour> mNeighbours = currentFragment.getNeighbours();
        onView(allOf(withId(R.id.list_neighbours),isDisplayed())).check(new RecyclerViewUtils.ItemCount(1));
        assert mNeighbours.get(0).getIsFavorite();
        assert mNeighbours.size()== 1;
        onView(allOf(withId(R.id.list_neighbours),isDisplayed())).check(matches(atPosition(0, hasDescendant(withText(mNeighbours.get(0).getName())))));
    }
}




