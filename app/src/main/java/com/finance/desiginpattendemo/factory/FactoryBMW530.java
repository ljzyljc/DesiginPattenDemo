package com.finance.desiginpattendemo.factory;


/**
 * Created by Jackie on 2018/6/21.
 */
public class FactoryBMW530 implements FactoryBMW {
    @Override
    public BMW createBMW() {
        System.out.println("----BMW530----");
        return new BMW530();
    }
}
