package com.finance.desiginpattendemo.mvp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.finance.desiginpattendemo.R;
import com.finance.desiginpattendemo.utiltest.EspressoIdlingResource;

/**
 * Created by Jackie on 2018/7/2.
 */
public class TestMvpActivity extends Activity implements BaseView{
    private Button btn_search;
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        btn_search = findViewById(R.id.btn_search);
        textView = findViewById(R.id.text);
        imageView = findViewById(R.id.image);
        final BasePresenter basePresenter = new BasePresenter(this);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                basePresenter.getUserName();
                //异步开始了
                EspressoIdlingResource.increment();
//                SystemClock.sleep(2000);
                Glide.with(TestMvpActivity.this)
                        .load("http://imgsrc.baidu.com/imgad/pic/item/caef76094b36acaf0accebde76d98d1001e99ce7.jpg")
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                textView.setText("success");
                                //图片加载成功结束异步
                                if (!EspressoIdlingResource.getIdlingResource().isIdleNow()){
                                    EspressoIdlingResource.decrement();
                                }
                                return false;
                            }
                        }).into(imageView);



            }
        });
    }

    @Override
    public void result(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        textView.setText(msg);
    }


    @VisibleForTesting
    public IdlingResource getCountingIdlingResource(){
        return EspressoIdlingResource.getIdlingResource();
    }

}
