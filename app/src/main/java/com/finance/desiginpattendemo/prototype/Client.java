package com.finance.desiginpattendemo.prototype;

import com.finance.desiginpattendemo.proxy.UserDao;

import java.io.InputStream;

/**
 * Created by Jackie on 2018/6/21.
 */
public class Client {
    public static void main(String[] args) {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        for (int i= 0;i<10;i++){
            ConcretePrototype concretePrototype1 = (ConcretePrototype) concretePrototype.clone();
            concretePrototype1.show();

        }
//        ClassLoader classLoader = new ClassLoader() {
//            @Override
//            public Class<?> loadClass(String name) throws ClassNotFoundException {
//                try {
//                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
//                    InputStream inputStream = getClass().getResourceAsStream(fileName);
//                    if (inputStream == null) {
//                        return super.loadClass(name);
//                    }
//                    byte[] b = new byte[inputStream.available()];
//                    inputStream.read(b);
//                    return defineClass(name,b,0,b.length);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//                return null;
//            }
//        };
//        try {
//            Object object = classLoader.loadClass("com.finance.desiginpattendemo.prototype.Client").newInstance();
//            System.out.println(object.getClass());
//            System.out.println(object instanceof com.finance.desiginpattendemo.prototype.Client);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


    }
}
