package com.wzx.tools;

import java.math.BigDecimal;

/**
 * 描述：
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/3
 * 更新时间：
 * 更新内容：
 */

public class ArithmeticUtils implements IArithmeticUtils {

    /**
     * 加
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public BigDecimal add(String x, String y) {
        return new BigDecimal(x).add(new BigDecimal(y));
    }

    /**
     * 减
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public BigDecimal sub(String x, String y) {
        return new BigDecimal(x).subtract(new BigDecimal(y));
    }

    /**
     * 乘
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public BigDecimal mul(String x, String y) {
        return new BigDecimal(x).multiply(new BigDecimal(y));
    }

    /**
     * 除
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public BigDecimal div(String x, String y) {
        return new BigDecimal(x).subtract(new BigDecimal(y));
    }

    /**
     * 精确
     *
     * @param x
     * @param digit
     * @param model
     * @return
     */
    @Override
    public BigDecimal scale(String x, int digit, int model) {
        return new BigDecimal(x).setScale(digit, model);
    }
}
