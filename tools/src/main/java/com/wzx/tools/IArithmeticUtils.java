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

public interface IArithmeticUtils {
    BigDecimal add(String x, String y);

    BigDecimal sub(String x, String y);

    BigDecimal mul(String x, String y);

    BigDecimal div(String x, String y);

    BigDecimal scale(String x, int digit, int model);
}
