package com.finance.desiginpattendemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Jackie on 2018/6/22.
 */
public class IntentTestActivity extends Activity {
    private static final String TAG = "IntentTestActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        Log.i(TAG, "IntentTestActivity--------onCreate:-------onClick--------- ");
//        ArrayList<Bitmap> list = (ArrayList<Bitmap>) getIntent().getSerializableExtra("list");
        if (getIntent().getSerializableExtra("bitmap")!=null){
            Log.i(TAG, "onCreate: ------onClick---------接收到了数据");
        }
        ImageView imageView = findViewById(R.id.img);
//        imageView.setImageBitmap(list.get(0));
    }
}
