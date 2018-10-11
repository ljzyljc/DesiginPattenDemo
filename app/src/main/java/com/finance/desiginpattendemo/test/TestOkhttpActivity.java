package com.finance.desiginpattendemo.test;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.finance.desiginpattendemo.R;

import java.io.IOException;
import java.util.HashMap;

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
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testokhttp);
        btn_okhttp = findViewById(R.id.btn_okhttp);
        okhtt_test = findViewById(R.id.okhtt_test);
//        System.out.println("<------------- 数据量100000 散列程度小 Map 倒序插入--------------->");
//        HashMap<Integer, String> map_2 = new HashMap<Integer, String>();
//        long start_map_2 = System.currentTimeMillis();
        int MAX = 100000;
//        for(int i=MAX-1;i>=0;i--){
//            map_2.put(MAX-i-1, String.valueOf(MAX-i-1));
//        }
//        long map_memory_2 = Runtime.getRuntime().totalMemory();
//        long end_map_2 = System.currentTimeMillis()-start_map_2;
//        System.out.println("<---Map的插入时间--->"+end_map_2+"<---Map占用的内存--->"+map_memory_2);

        //执行后的结果：
//  <------------- 数据量100000 Map 倒序插入--------------->
//  <---Map的插入时间--->836<---Map占用的内存--->28598272


//        System.out.println("<------------- 数据量100000 散列程度小 SparseArray 倒序插入--------------->");
//        SparseArray<String>sparse_2 = new SparseArray<String>();
//        long start_sparse_2 = System.currentTimeMillis();
//        for(int i=MAX-1;i>=0;i--){
//            sparse_2.put(i, String.valueOf(MAX-i-1));
//        }
//        long sparse_memory_2 = Runtime.getRuntime().totalMemory();
//        long end_sparse_2 = System.currentTimeMillis()-start_sparse_2;
//        System.out.println("<---Sparse的插入时间--->"+end_sparse_2+"<---Sparse占用的内存--->"+sparse_memory_2);

        //查询：
//        System.out.println("<------------- 数据量100000 Map查找--------------->");
//        HashMap<Integer, String>map = new HashMap<Integer, String>();
//
//        for(int i=0;i<MAX;i++){
//            map.put(i, String.valueOf(i));
//        }
//        long start_time =System.currentTimeMillis();
//        for(int i=0;i<MAX;i+=1){
//            map.get(i);
//        }
//        long end_time =System.currentTimeMillis()-start_time;
//        System.out.println("<-----"+end_time);

        //执行后的结果
//  <!---------查找的时间:175------------>
        System.out.println("<------------- 数据量100000  SparseArray 查找--------------->");
        SparseArray<String>sparse = new SparseArray<String>();
        for(int i=0;i<MAX;i++){
            sparse.put(i, String.valueOf(i));
        }
        long start_time =System.currentTimeMillis();

        for(int i=0;i<MAX;i+=1){
            sparse.get(i);
        }
        long end_time =System.currentTimeMillis()-start_time;
        System.out.println("<-----"+end_time);
//        ArrayMap<Boolean,String> ss = new ArrayMap<>();
        //执行后的结果
//  <!-----------查找的时间:239---------------->

//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            String msg = requestRun("http://gaapi.jl.gov.cn:80/econsole/api/news/top/3");
//                            SystemClock.sleep(1500);
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//
//                                    Log.i(TAG, "onClick: ---1---2---");
//                                    btn_okhttp.setText("txt");
//                                }
//                            });
//
//                            Log.i(TAG, "onClick: ---1------"+msg);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();
//                reportFullyDrawn();

//            }
//        });
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
