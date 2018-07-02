package com.finance.desiginpattendemo.utiltest;

import android.support.test.espresso.IdlingResource;

/**
 * Created by Jackie on 2018/7/2.
 * 定义一个该IdlingResource的管理类EspressoIdlingResource：
 */
public class EspressoIdlingResource {

    private static final String RESOURCE = "GLOBAL";
    private static SimpleCountingIdlingResource simpleCountingIdlingResource
            = new SimpleCountingIdlingResource(RESOURCE);

    public static void increment(){
        simpleCountingIdlingResource.increment();
    }

    public static void decrement(){
        simpleCountingIdlingResource.decrement();
    }

    public static IdlingResource getIdlingResource(){
        return simpleCountingIdlingResource;
    }


}
