package com.finance.desiginpattendemo.productorconsumer;

/**
 * Created by Jackie on 2018/10/8.
 */
public class PCData {

    private final int intData;
    public PCData(int d){
        intData = d;
    }
    public PCData(String d){
        intData = Integer.valueOf(d);
    }
    public int getData(){
        return intData;
    }
    @Override
    public String toString(){
        return "data:"+intData;
    }
}
