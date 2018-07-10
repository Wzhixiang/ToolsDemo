package com.wzx.tools;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 描述：
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/9
 * 更新时间：
 * 更新内容：
 */
public class TimeUtilsTest {
    @Test
    public void timestampToFormat() throws Exception {
        System.out.println(TimeUtils.longAgo13(110610000));
        System.out.println(TimeUtils.formatDHMS(110610));
    }
}