package com.finance.desiginpattendemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Jackie on 2018/6/26.
 * 动态代理不需要实现接口，但是需要指定接口类型
 */
public class ProxyFactory {

    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("-------开始动态代理-----");
                        //执行目标方法
                        Object returenValue = method.invoke(target,args);
                        System.out.println("-------提交动态代理-----");
                        return returenValue;
                    }
                });

    }


}
