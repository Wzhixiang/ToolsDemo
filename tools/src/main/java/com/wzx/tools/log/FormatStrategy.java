package com.wzx.tools.log;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 描述：设置logger输出格式
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/2
 * 更新时间：
 * 更新内容：
 */

public interface FormatStrategy {
    void log(int priority, @Nullable String tag, @NonNull String message);
}
