package com.wzx.tools;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

/**
 * 描述：Toast
 *
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/3
 * 更新时间：
 * 更新内容：
 */

public class ToastUtills {

    private static Toast mToast;

    private static boolean hasView = false;

    public ToastUtills() {
        throw new UnsupportedOperationException("不能被实例化");
    }

    public static void showLong(Context context, CharSequence msg) {
        if (mToast == null || hasView) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        hasView = false;
        mToast.show();
    }


    public static void showLong(Context context, int msgId) {

        if (mToast == null || hasView) {
            mToast = Toast.makeText(context, msgId, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msgId);
            mToast.setDuration(Toast.LENGTH_LONG);
        }hasView = false;
        mToast.show();
    }

    public static void showShort(Context context, CharSequence msg) {

        if (mToast == null || hasView) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }hasView = false;
        mToast.show();
    }


    public static void showShort(Context context, int msgId) {

        if (mToast == null || hasView) {
            mToast = Toast.makeText(context, msgId, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msgId);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }hasView = false;
        mToast.show();
    }

    public static void showGravity(Context context, CharSequence msg, int gravity, int x, int y) {

        if (mToast == null || hasView) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_LONG);
        }hasView = false;
        mToast.setGravity(gravity, x, y);
        mToast.show();
    }


    public static void showGravity(Context context, int msgId, int gravity, int x, int y) {

        if (mToast == null || hasView) {
            mToast = Toast.makeText(context, msgId, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msgId);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        hasView = false;
        mToast.setGravity(gravity, x, y);
        mToast.show();
    }


    public static void showView(Context context, CharSequence msg, @NonNull View view) {
        hasView = true;
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.setView(view);
        mToast.show();
    }


    public static void showView(Context context, int msgId, View view) {
        hasView = true;
        if (mToast == null) {
            mToast = Toast.makeText(context, msgId, Toast.LENGTH_LONG);
        } else {
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.setView(view);
        mToast.show();
    }


    public static void cancel() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}
