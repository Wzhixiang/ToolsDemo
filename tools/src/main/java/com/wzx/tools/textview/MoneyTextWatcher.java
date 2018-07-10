package com.wzx.tools.textview;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * 描述：限制输入两位小数，小数点前自动补0
 * {@link android.widget.TextView  addTextChangedListener(TextWatcher textWatcher)监听文本变化}
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/9
 * 更新时间：
 * 更新内容：
 */

public class MoneyTextWatcher implements TextWatcher {

    private EditText editText;
    private int digits = 2;

    public MoneyTextWatcher(Builder builder) {
        this.editText = builder.editText;
        this.digits = builder.digits;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //删除“.”后面超过2位后的数据
        if (charSequence.toString().contains(".")) {
            if (charSequence.length() - 1 - charSequence.toString().indexOf(".") > digits) {
                charSequence = charSequence.toString().subSequence(0,
                        charSequence.toString().indexOf(".") + digits + 1);
                editText.setText(charSequence);
                editText.setSelection(charSequence.length()); //光标移到最后
            }
        }
        //如果"."在起始位置,则起始位置自动补0
        if (charSequence.toString().trim().substring(0).equals(".")) {
            charSequence = "0" + charSequence;
            editText.setText(charSequence);
            editText.setSelection(2);
        }

        //如果起始位置为0,且第二位跟的不是".",则无法后续输入
        if (charSequence.toString().startsWith("0")
                && charSequence.toString().trim().length() > 1) {
            if (!charSequence.toString().substring(1, 2).equals(".")) {
                editText.setText(charSequence.subSequence(0, 1));
                editText.setSelection(1);
                return;
            }
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    public static class Builder {
        private EditText editText;
        private int digits;

        public Builder addEdittext(EditText et) {
            editText = et;
            return this;
        }

        public Builder setDigits(int digits) {
            this.digits = digits;
            return this;
        }

        public MoneyTextWatcher build() {
            if (editText == null) {
                throw new NullPointerException("输入框不能为空");
            }
            if (digits == 0) {
                digits = 2;
            }
            return new MoneyTextWatcher(this);
        }
    }
}
