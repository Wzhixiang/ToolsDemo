package com.wzx.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述：
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/3
 * 更新时间：
 * 更新内容：
 */

public class TimeUtils {
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");

    private TimeUtils() {
        throw new UnsupportedOperationException("不允许初始化");
    }

    /**
     * 时间戳转时间字符串
     *
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * 时间戳转自定义时间格式
     *
     * @param timeInMillis
     * @return
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }

    /**
     * 当前时间戳（毫秒）
     *
     * @return
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * 当前时间 {@link #DEFAULT_DATE_FORMAT}
     *
     * @return
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }

    /**
     * 时间格式
     *
     * @return
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }

    /**
     * 将13位时间差转换成多久前
     *
     * @param timaStamp
     * @return
     */
    public static String longAgo13(long timaStamp) {
        long stamp = timaStamp / 1000;
        return longAgo(stamp);
    }

    /**
     * 将10时间差转换成多久前
     *
     * @param stamp 10位时间差
     * @return
     */
    public static String longAgo(long stamp) {
        if (stamp < 60) {
            return "刚刚";
        } else if (stamp >= 60 && stamp < 3600) {
            return stamp / 60 + "分钟前";
        } else if (stamp >= 3600 && stamp < 3600 * 24) {
            return stamp / 3600 + "小时前";
        } else if (stamp >= 3600 * 24 && stamp < 3600 * 24 * 30) {
            return stamp / 3600 / 24 + "天前";
        } else if (stamp >= 3600 * 24 * 30 && stamp < 3600 * 24 * 30 * 12) {
            return stamp / 3600 / 24 / 30 + "个月前";
        } else {
            return "很久以前";
        }
    }

    /**
     * 天时分秒格式
     *
     * @param timaStamp 13位时间戳
     * @return
     */
    public static String formatDHMS13(long timaStamp) {
        return formatDHMS(timaStamp / 1000);
    }

    /**
     * 天时分秒格式
     *
     * @param timaStamp 10位时间戳
     * @return
     */
    public static String formatDHMS(long timaStamp) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(timaStamp / (60 * 60 * 24)).append("天");
        timaStamp = timaStamp % (60 * 60 * 24);
        stringBuffer.append(timaStamp / (60 * 60)).append("时");
        timaStamp = timaStamp % (60 * 60);
        stringBuffer.append(timaStamp / 60).append("分");
        timaStamp = timaStamp % 60;
        stringBuffer.append(timaStamp).append("秒");
        return stringBuffer.toString();
    }
}
