package com.finance.desiginpattendemo.mvp;

/**
 * Created by Jackie on 2018/7/2.
 */
public class BasePresenter {
    private BaseModel baseModel;
    private BaseView baseView;

    public BasePresenter(BaseView baseView){
        baseModel = new BaseModel();
        this.baseView = baseView;
    }

    public String getUserName(){
        baseModel.getData(new BaseModel.OnResultListener() {
            @Override
            public void onMyResult(String result) {
                baseView.result(result);
            }

        });
        return "ljc";
    }





}
