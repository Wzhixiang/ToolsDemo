package com.wzx.tools.keyboard;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * 描述：软件盘控制
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/9
 * 更新时间：
 * 更新内容：
 */

public class KeyBoardUtils {

    /**
     * 关闭软键盘
     *
     * @param context
     */
    public static void closeKeyBoard(Context context) {
        InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }


}
