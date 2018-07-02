package com.finance.desiginpattendemo.asyntest;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.finance.desiginpattendemo.R;
import com.finance.desiginpattendemo.test.TestOkhttpActivity;
import com.finance.desiginpattendemo.utiltest.OkhttpProvider;
import com.jakewharton.espresso.OkHttp3IdlingResource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Jackie on 2018/7/2.
 * Okhttp的测试类
 */
@RunWith(AndroidJUnit4.class)
public class OkhttpActivityTest {

    @Rule
    public ActivityTestRule<TestOkhttpActivity> rule = new ActivityTestRule<>(TestOkhttpActivity.class);

    @Test
    public void requestOkhttpTest() throws Exception{
        //初始化
        OkHttp3IdlingResource idlingResource = OkHttp3IdlingResource.create("okhttp", OkhttpProvider.getOkHttpInstance());
        //注册
        Espresso.registerIdlingResources(idlingResource);
        Espresso.onView(withId(R.id.btn_okhttp)).perform(click());

        Espresso.onView(withId(R.id.okhtt_test)).check(matches(withText("txt")));
        //解除注册
        Espresso.unregisterIdlingResources(idlingResource);

    }



}
