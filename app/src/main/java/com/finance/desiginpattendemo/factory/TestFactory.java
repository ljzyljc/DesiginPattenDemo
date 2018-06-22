package com.finance.desiginpattendemo.factory;

import com.finance.desiginpattendemo.factory.abstrat.FactoryBMW530;
import com.finance.desiginpattendemo.factory.abstrat.FactoryBMW750;

/**
 * Created by Jackie on 2018/6/21.
 */
public class TestFactory {

    public static void main(String[] args) {
        //---------工厂方法-----------------
//        FactoryBMW bmw530 = new FactoryBMW530();
//        bmw530.createBMW();
//
//        FactoryBMW bmw750 = new FactoryBMW750();
//        bmw750.createBMW();

        //--------抽象工厂------------------

        FactoryBMW530 factoryBMW530 = new FactoryBMW530();
        factoryBMW530.createEngine();
        factoryBMW530.createCondition();

        FactoryBMW750 factoryBMW750 = new FactoryBMW750();
        factoryBMW750.createCondition();
        factoryBMW750.createEngine();

    }

}
