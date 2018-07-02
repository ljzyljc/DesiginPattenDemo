package com.finance.desiginpattendemo.asyntest;

import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.finance.desiginpattendemo.R;
import com.finance.desiginpattendemo.mvp.TestMvpActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Jackie on 2018/7/2.
 */
@RunWith(AndroidJUnit4.class)
public class AsynActivityTest {

    @Rule
    public ActivityTestRule<TestMvpActivity> activityTestRule = new ActivityTestRule<>(TestMvpActivity.class);
    private IdlingResource idlingResource;

    @Before
    public void setUp() throws Exception{
        //调用Activity中我们已经设置好的getIdlingresource()方法，获取Idlingresource对象
        idlingResource = activityTestRule.getActivity().getCountingIdlingResource();
        //去掉下行注释，只有异步结束后，才进行接下来的测试代码（tests passed）
        //注册异步监听，当该idlingresource中的counter标记值为0时才进行接下来的测试代码
        Espresso.registerIdlingResources(idlingResource);
        System.out.print("jackie------------------------------------------");
    }


    //异步测试，先点击按钮，再测试
    @Test
    public void onLoadFinished() throws Exception{
        Espresso.onView(withId(R.id.btn_search)).perform(click());
        Espresso.onView(withId(R.id.text)).check(matches(withText("success")));
    }

    @After
    public void release() throws Exception{
        System.out.print("jackie----------------release--------------------------");
        Espresso.unregisterIdlingResources(idlingResource);
    }


}
