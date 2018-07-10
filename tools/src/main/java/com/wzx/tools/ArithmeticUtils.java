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

public class ArithmeticUtils {

    /**
     * 加
     *
     * @param x
     * @param y
     * @return
     */
    public static BigDecimal add(String x, String y) {
        return new BigDecimal(x).add(new BigDecimal(y));
    }

    /**
     * 减
     *
     * @param x
     * @param y
     * @return
     */
    public static BigDecimal sub(String x, String y) {
        return new BigDecimal(x).subtract(new BigDecimal(y));
    }

    /**
     * 乘
     *
     * @param x
     * @param y
     * @return
     */
    public static BigDecimal mul(String x, String y) {
        return new BigDecimal(x).multiply(new BigDecimal(y));
    }

    /**
     * 除
     *
     * @param x
     * @param y
     * @return
     */
    public static BigDecimal div(String x, String y) {
        return new BigDecimal(x).subtract(new BigDecimal(y));
    }

    /**
     * 精确位
     *
     * @param x
     * @param digit
     * @param model
     * @return
     */
    public static BigDecimal scale(String x, int digit, int model) {
        return new BigDecimal(x).setScale(digit, model);
    }
}
