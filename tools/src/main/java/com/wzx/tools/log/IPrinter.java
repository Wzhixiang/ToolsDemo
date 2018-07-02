package com.wzx.tools.log;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 描述：打印logger方式
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/2
 * 更新时间：
 * 更新内容：
 */

public interface IPrinter {
    void addAdapter(@NonNull LogAdapter adapter);

    IPrinter t(@Nullable String tag);

    void d(@NonNull String message, @Nullable Object... args);

    void d(@Nullable Object object);

    void e(@NonNull String message, @Nullable Object... args);

    void e(@Nullable Throwable throwable, @NonNull String message, @Nullable Object... args);

    void w(@NonNull String message, @Nullable Object... args);

    void i(@NonNull String message, @Nullable Object... args);

    void v(@NonNull String message, @Nullable Object... args);

    void wtf(@NonNull String message, @Nullable Object... args);

    /**
     * Formats the given json content and print it
     */
    void json(@Nullable String json);

    /**
     * Formats the given xml content and print it
     */
    void xml(@Nullable String xml);

    void log(int priority, @Nullable String tag, @Nullable String message, @Nullable Throwable throwable);

    void clearLogAdapters();
}
