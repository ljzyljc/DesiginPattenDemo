package com.finance.desiginpattendemo.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.finance.desiginpattendemo.R;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Jackie on 2018/7/2.
 */
public class TestOkhttpActivity extends Activity {
    private Button btn_okhttp;
    private static final String TAG = "TestOkhttpActivity";
    private static final String url = "";
    private TextView okhtt_test;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testokhttp);
        btn_okhttp = findViewById(R.id.btn_okhttp);
        okhtt_test = findViewById(R.id.okhtt_test);
        btn_okhttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String msg = requestRun("http://gaapi.jl.gov.cn:80/econsole/api/news/top/3");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    okhtt_test.setText("txt");
                                }
                            });

                            Log.i(TAG, "onClick: ---1------"+msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        });
    }

    OkHttpClient client = new OkHttpClient();

    public String requestRun(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }



}
