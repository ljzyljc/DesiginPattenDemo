package com.finance.desiginpattendemo.factory.abstrat;

/**
 * Created by Jackie on 2018/6/21.
 */
public class FactoryBMW750 implements AbstractFactory {
    @Override
    public Engine createEngine() {
        return new EngineTwo();
    }

    @Override
    public AirCondition createCondition() {
        return new AirConditionTwo();
    }
}
