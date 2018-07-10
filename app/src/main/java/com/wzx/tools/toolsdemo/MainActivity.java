package com.wzx.tools.toolsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.wzx.tools.GsonUtils;
import com.wzx.tools.ToastUtills;
import com.wzx.tools.log.AndroidLogAdapter;
import com.wzx.tools.log.DiskLogAdapter;
import com.wzx.tools.log.Logger;
import com.wzx.tools.textview.InputLowerToUpper;
import com.wzx.tools.textview.MoneyTextWatcher;


public class MainActivity extends AppCompatActivity {

    private EditText edTran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化Logger
//        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.addLogAdapter(new DiskLogAdapter());

        edTran = findViewById(R.id.ed_tran);

        edTran.setTransformationMethod(new InputLowerToUpper());

        edTran.addTextChangedListener(new MoneyTextWatcher.Builder().addEdittext(edTran).build());
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Logger.i("log messag in io thread");
            }
        }).start();

        String userJson = "{\"name\":\"wzx\", \"sex\":\"0\"}";

        //Logger打印json
        Logger.json(userJson);
        //gson转换
        User user = GsonUtils.gsonToBean(userJson, User.class);
        Logger.i(user.getName());

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
