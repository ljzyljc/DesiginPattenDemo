package com.finance.desiginpattendemo;
import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.EspressoException;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

/**
 * Created by Jackie on 2018/6/21.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    private String[] names = {"", "a", "123123"};
    private String[] pwds = {"", "a", "123123"};
    @Rule
    public ActivityTestRule<LoginActivity> rule = new ActivityTestRule<>(LoginActivity.class);



    @Test
    public void loginTest(){

//        Espresso.onView(withId(R.id.login))
//                .check(matches(not(isDisplayed())));
//        onView(allOf(withId(R.id.login),withText("登录"))).check(matches(not(isDisplayed())));
        //不做任何输入，直接点击登录
        onView(allOf(withId(R.id.login),isDisplayed())).perform(click());
        onView(allOf(withId(R.id.login_result),isDisplayed())).check(matches(withText("用户名为空")));
        //用户名是空，点击登录
        onView(allOf(withId(R.id.edit_username),isDisplayed())).perform(replaceText(names[0]),closeSoftKeyboard());
        onView(allOf(withId(R.id.login),isDisplayed())).perform(click());
        onView(allOf(withId(R.id.login_result),isDisplayed())).check(matches(withText("用户名为空")));
        SystemClock.sleep(1000);
        //用户名格式错误
        onView(allOf(withId(R.id.edit_username),isDisplayed())).perform(replaceText(names[1]),closeSoftKeyboard());
        onView(allOf(withId(R.id.login),isDisplayed())).perform(click());
        onView(allOf(withId(R.id.login_result),isDisplayed())).check(matches(withText("用户名格式错误")));
        SystemClock.sleep(1000);
        //用户名和密码都正确，点击登录
        onView(allOf(withId(R.id.edit_username),isDisplayed())).perform(replaceText(names[2]),closeSoftKeyboard());
        onView(allOf(withId(R.id.edit_pwd),isDisplayed())).perform(replaceText(names[2]),closeSoftKeyboard());
        onView(allOf(withId(R.id.login),isDisplayed())).perform(click());
        onView(allOf(withId(R.id.login_result),isDisplayed())).check(matches(withText("登录成功")));

        SystemClock.sleep(1000);
    }


}
