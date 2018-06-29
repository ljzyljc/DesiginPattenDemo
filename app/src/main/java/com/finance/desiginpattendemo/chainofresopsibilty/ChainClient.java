package com.finance.desiginpattendemo.chainofresopsibilty;

/**
 * Created by Jackie on 2018/6/28.
 */
public class ChainClient {
    public static void main(String[] args) {
        ConcreteHandler concreteHandler = new ConcreteHandler();
        ConcreteHandler concreteHandler1 = new ConcreteHandler();
        concreteHandler.setSucessor(concreteHandler1);
        concreteHandler.handlerRequest();

    }
}
