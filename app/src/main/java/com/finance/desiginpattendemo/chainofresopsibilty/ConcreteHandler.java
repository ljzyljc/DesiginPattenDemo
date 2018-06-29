package com.finance.desiginpattendemo.chainofresopsibilty;

/**
 * Created by Jackie on 2018/6/28.
 */
public class ConcreteHandler extends Handler {

    @Override
    public void handlerRequest() {
        //有下一个处理者,放过请求
        if (getSucessor()!=null){
            getSucessor().handlerRequest();
            System.out.println("-------放过请求------");
        }else{    //自己处理
            System.out.println("-------自己动手，丰衣足食------");
        }
    }
}
