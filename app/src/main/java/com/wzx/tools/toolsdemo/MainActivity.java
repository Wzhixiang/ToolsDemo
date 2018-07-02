package com.wzx.tools.toolsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wzx.tools.log.AndroidLogAdapter;
import com.wzx.tools.log.Logger;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化Logger
        Logger.addLogAdapter(new AndroidLogAdapter());
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
}
