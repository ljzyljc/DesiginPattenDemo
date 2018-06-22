package com.finance.desiginpattendemo.factory.abstrat;

/**
 * Created by Jackie on 2018/6/21.
 */
public class FactoryBMW530 implements AbstractFactory{


    @Override
    public Engine createEngine() {
        return new EngineOne();
    }

    @Override
    public AirCondition createCondition() {
        return new AirConditionOne();
    }
}
