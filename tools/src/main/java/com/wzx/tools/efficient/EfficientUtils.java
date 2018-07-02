package com.wzx.tools.efficient;

import android.util.Log;

/**
 * 描述：计算方法执行时间
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/2
 * 更新时间：
 * 更新内容：
 */

public class EfficientUtils {


    public EfficientUtils() {
        new Throwable("不允许执行构造方法");
    }

    public static void executionTime(ITodo efficient) {
        //开始时间
        long startTime = System.currentTimeMillis();
        System.out.println(String.format("开始时间 %d ms", startTime));
        efficient.todo(); ///进行回调操作
        //结束时间
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("结束时间 %d ms", endTime));
        System.out.println(String.format("方法使用时间 %d ms", endTime - startTime));

    }
}
