package com.wzx.tools.textview;

import android.text.method.ReplacementTransformationMethod;
import android.text.method.TransformationMethod;

/**
 * 描述：将输入小写字母转换为大写
 * {@link android.widget.TextView setTransformationMethod（TransformationMethod method）设置TextView文字转换方式}
 * {@link ReplacementTransformationMethod 数据源替换}
 * {@link TransformationMethod 数据转换接口}
 *
 * 系统实现TransformationMethod接口的类有
 * {@link android.text.method.HideReturnsTransformationMethod 隐藏回车}
 * {@link android.text.method.SingleLineTransformationMethod 当行（不能使用换行回车）}
 * {@link android.text.method.PasswordTransformationMethod 密码转换}
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/9
 * 更新时间：
 * 更新内容：
 */

public class InputLowerToUpper extends ReplacementTransformationMethod {

    @Override
    protected char[] getOriginal() {
        char[] lower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z'};
        return lower;
    }

    @Override
    protected char[] getReplacement() {
        char[] upper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        return upper;
    }
}
