package com.finance.desiginpattendemo.mvp;

/**
 * Created by Jackie on 2018/7/2.
 */
public class BaseModel {
    private String name;


    public void  getData(OnResultListener onResultListener){
        //模拟网络请求，假设成功
        onResultListener.onMyResult("获取网络数据成功");

    }


    public interface OnResultListener{
        void onMyResult(String result);
    }
}
