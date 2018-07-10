package com.wzx.tools;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 描述：
 * {@link SharedPreferences 轻量级数据存储类}
 * {@link #putParam(Context, String, Object) 根据数据类型保存数据}
 * {@link #getParam(Context, String, Object) 根据默认值读取数据}
 * {@link #clear(Context, String) 清除指定数据}
 * {@link #clearAll(Context) 清除所有数据}
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/10
 * 更新时间：
 * 更新内容：
 */

public class SharedPreferencesUtils {

    private static final String SHAREPREFERENCE_NAME = "preference";

    public SharedPreferencesUtils() {
        throw new UnsupportedOperationException("不允许初始化");
    }

    public static boolean putString(Context context, String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static String getString(Context context, String key) {
        return getString(context, key, null);
    }

    public static String getString(Context context, String key, String defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, defaultValue);
    }

    public static boolean putInt(Context context, String key, int value) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static int getInt(Context context, String key) {
        return getInt(context, key, -1);
    }

    public static int getInt(Context context, String key, int defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getInt(key, defaultValue);
    }

    public static boolean putLong(Context context, String key, long value) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public static long getLong(Context context, String key) {
        return getLong(context, key, -1);
    }

    public static long getLong(Context context, String key, long defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getLong(key, defaultValue);
    }

    public static boolean putFloat(Context context, String key, float value) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    public static float getFloat(Context context, String key) {
        return getFloat(context, key, -1);
    }

    public static float getFloat(Context context, String key, float defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getFloat(key, defaultValue);
    }

    public static boolean putBoolean(Context context, String key, boolean value) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, false);
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, defaultValue);
    }

    /**
     * 保存数据（根据需保存数据类型使用相对应方法）
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static boolean putParam(Context context, String key, Object value) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String type = value.getClass().getSimpleName();
        if ("String".equals(type)) {
            editor.putString(key, (String) value);
        } else if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) value);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) value);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) value);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) value);
        }

        return editor.commit();
    }

    /**
     * 读取数据（根据默认值读取数据）
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static Object getParam(Context context, String key, Object defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        String type = defaultValue.getClass().getSimpleName();

        if ("String".equals(type)) {
            return settings.getString(key, (String) defaultValue);
        } else if ("Integer".equals(type)) {
            return settings.getInt(key, (Integer) defaultValue);
        } else if ("Boolean".equals(type)) {
            return settings.getBoolean(key, (Boolean) defaultValue);
        } else if ("Float".equals(type)) {
            return settings.getFloat(key, (Float) defaultValue);
        } else if ("Long".equals(type)) {
            return settings.getLong(key, (Long) defaultValue);
        } else {
            return defaultValue;
        }
    }

    /**
     * 清除指定数据
     *
     * @param context
     */
    public static void clear(Context context, String key) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 清除所有数据
     *
     * @param context
     */
    public static void clearAll(Context context) {
        SharedPreferences settings = context.getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear().commit();
    }
}
