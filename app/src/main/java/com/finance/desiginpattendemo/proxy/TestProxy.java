package com.finance.desiginpattendemo.proxy;

/**
 * Created by Jackie on 2018/6/26.
 */
public class TestProxy {
    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
//        userDaoProxy.saveData();  //执行的是静态代理的方法


        //动态代理
        IUserDao target = new UserDao();
        System.out.println(target.getClass());

        //给目标对象创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());

        proxy.saveData();

    }
}
