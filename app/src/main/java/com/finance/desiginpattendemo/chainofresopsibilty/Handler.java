package com.finance.desiginpattendemo.chainofresopsibilty;

/**
 * Created by Jackie on 2018/6/28.
 */
public abstract class Handler {

    protected Handler sucessor;

    public void setSucessor(Handler sucessor) {
        this.sucessor = sucessor;
    }

    public Handler getSucessor() {
        return sucessor;
    }
    public abstract void handlerRequest();
}
