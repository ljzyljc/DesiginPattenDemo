package com.finance.desiginpattendemo.prototype;

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
    }
}
