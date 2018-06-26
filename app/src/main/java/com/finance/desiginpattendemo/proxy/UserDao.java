package com.finance.desiginpattendemo.proxy;

/**
 * Created by Jackie on 2018/6/26.
 */
public class UserDao implements IUserDao{
    @Override
    public void saveData() {
        System.out.print("---UserDao----");
    }
}
