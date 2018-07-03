package com.wzx.tools.toolsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.wzx.tools.ToastUtills;
import com.wzx.tools.log.AndroidLogAdapter;
import com.wzx.tools.log.DiskLogAdapter;
import com.wzx.tools.log.Logger;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化Logger
//        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.addLogAdapter(new DiskLogAdapter());
    }

    @Override
    protected void onStart() {
        super.onStart();

//        Logger.i("message");

        new Thread(new Runnable() {
            @Override
            public void run() {
                Logger.i("log messag in io thread");
            }
        }).start();

//        Logger.json("{\"value\": \"New\", \"onclick\": \"CreateNewDoc\",\"value\": \"New\", \"onclick\": \"CreateNewDoc\",\"value\": \"New\", \"onclick\": \"CreateNewDoc\"}");
    }

    public void onToast(View view) {
        switch (view.getId()) {
            case R.id.btn_long:
                ToastUtills.showLong(this, "长Toast");
                break;
            case R.id.btn_short:
                ToastUtills.showShort(this, "短Toast");
                break;
            case R.id.btn_view:
                View view1 = LayoutInflater.from(this).inflate(R.layout.view_toast, null, false);
                ToastUtills.showView(this, "自定义view", view1);
                break;
            case R.id.btn_gravity:
                ToastUtills.showGravity(this, "自定义位置", Gravity.BOTTOM, 0, 100);
                break;
            default:
                break;
        }
    }
}
