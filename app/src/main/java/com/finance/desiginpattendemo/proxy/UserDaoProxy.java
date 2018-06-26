package com.finance.desiginpattendemo.proxy;

/**
 * Created by Jackie on 2018/6/26.
 */
public class UserDaoProxy implements IUserDao {
    private IUserDao iUserDao;
    public UserDaoProxy(IUserDao iUserDao){
        this.iUserDao = iUserDao;
    }
    @Override
    public void saveData() {
        System.out.println("-------代理对象----");
        iUserDao.saveData();
    }
}
