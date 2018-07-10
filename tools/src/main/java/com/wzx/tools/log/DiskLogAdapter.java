package com.wzx.tools.log;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.wzx.tools.StringUtils.checkNotNull;

/**
 * 描述：
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/2
 * 更新时间：
 * 更新内容：
 */

public class DiskLogAdapter implements LogAdapter {
    @NonNull
    private final FormatStrategy formatStrategy;

    public DiskLogAdapter() {
        formatStrategy = CsvFormatStrategy.newBuilder().build();
    }

    public DiskLogAdapter(@NonNull FormatStrategy formatStrategy) {
        this.formatStrategy = checkNotNull(formatStrategy);
    }

    @Override
    public boolean isLoggable(int priority, @Nullable String tag) {
        return true;
    }

    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message) {
        formatStrategy.log(priority, tag, message);
    }
}
