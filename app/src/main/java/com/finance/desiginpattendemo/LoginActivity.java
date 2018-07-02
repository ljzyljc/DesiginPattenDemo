package com.finance.desiginpattendemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.finance.desiginpattendemo.bean.IntentBean;

import java.util.ArrayList;

/**
 * Created by Jackie on 2018/6/21.
 */
public class LoginActivity extends Activity implements View.OnClickListener{

    private Button login;
    private EditText username;
    private EditText pwd;
    private TextView login_result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        login.setOnClickListener(this);
        username = findViewById(R.id.edit_username);
        pwd = findViewById(R.id.edit_pwd);
        username.setOnClickListener(this);
        pwd.setOnClickListener(this);
        login_result = findViewById(R.id.login_result);
    }
    public void login(){

        String name = username.getText().toString().trim();
        String password = pwd.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            login_result.setText("用户名为空");
            return;
        }
        if (name.length() < 6 ) {
            login_result.setText("用户名格式错误");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            login_result.setText("密码为空");
            return;
        }
        if (pwd.length() < 6 ) {
            login_result.setText("密码格式错误");
            return;
        }
        login_result.setText("登录成功");



    }

    private ArrayList<Bitmap> bitmapArrayList = new ArrayList<>(1);
    private static final String TAG = "LoginActivity";
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                login();
                //测试Intent最多能传多大
//                Intent intent = new Intent(this,IntentTestActivity.class);
//                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.p_cst_28);
//                bitmapArrayList.add(bitmap);
////                intent.putExtra("list",bitmapArrayList);
////                Log.i(TAG, "onClick: --------------------"+bitmapArrayList.size());
//                intent.putExtra("bitmap",bitmap);
//                startActivity(intent);
//                Log.i(TAG, "onClick: -------1---------------------");

                break;
            case R.id.edit_username:
                break;
            case R.id.edit_pwd:
                break;

        }



    }
}
