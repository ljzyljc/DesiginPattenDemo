package com.finance.desiginpattendemo.prototype;

/**
 * Created by Jackie on 2018/6/21.
 */
public class ProtoType implements Cloneable {

    public ProtoType clone(){
        ProtoType protoType = null;
        try {
            protoType = (ProtoType) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return protoType;

    }


}
