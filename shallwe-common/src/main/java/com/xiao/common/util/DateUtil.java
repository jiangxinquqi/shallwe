package com.xiao.common.util;

import java.time.*;
import java.util.Date;

/**
 * @desc: 功能描述：<时间工具类>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/6/17 8:24
 */
public class DateUtil {
    /**
     * <p> Date 转为 UTC（协调世界时）
     * <li> eg : 2021-04-08T07:46:18.425Z
     *
     * @param date 日期对象
     * @return OffsetDateTime
     */
    public static OffsetDateTime date2UTC(Date date) {
        return date2OffsetDateTime(date, ZoneOffset.UTC.getId());
    }

    /**
     * <p> Date 转为 UTC - 6（西六区时间-美国标准时间）
     * <li> eg : 2021-04-08T01:58:44.619-06:00
     *
     * @param date 日期对象
     * @return OffsetDateTime
     */
    public static OffsetDateTime date2UTCWest6(Date date) {
        return date2OffsetDateTime(date, "-6");
    }

    /**
     * <p> Date 转为 UTC + 8（东八区时间-中国标准时间-北京时间）
     * <li> eg : 2021-04-08T15:46:18.425+08:00
     *
     * @param date 日期对象
     * @return OffsetDateTime
     */
    public static OffsetDateTime date2UTCEast8(Date date) {
        return date2OffsetDateTime(date, "+8");
    }

    public static OffsetDateTime date2OffsetDateTime(Date date, String offsetId) {
        return date.toInstant().atOffset(ZoneOffset.of(offsetId));
    }

    /**
     * <p> Date 转为 时间 + 偏移量 + 时区 表示。
     * <li> eg : 2021-04-08T15:46:18.425+08:00[Asia/Shanghai]
     *
     * @param date 日期对象
     * @return ZonedDateTime
     */
    public static ZonedDateTime date2ZonedDateTime(Date date) {
        return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * <p> Date 转为 时间 + 偏移量 表示。
     * <li> eg : 2021-04-08T15:46:18.425+08:00[Asia/Shanghai]
     *
     * @param date 日期对象
     * @return ZonedDateTime
     */
    public static OffsetDateTime date2OffsetDateTime(Date date) {
        return OffsetDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * <p> Date 转为 时间，不带偏移量，不带时区。
     * <li> eg : 2021-04-08T14:33:31.912
     *
     * @param date 日期对象
     * @return LocalDateTime
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * <p> ZonedDateTime 转为 Date表示。
     *
     * @param zonedDateTime 日期对象     *
     * @return Date
     */
    public static Date zonedDateTime2Date(ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * <p> offsetDateTime 转为 Date表示。
     *
     * @param offsetDateTime 日期对象
     * @return Date
     */
    public static Date offsetDateTime2Date(OffsetDateTime offsetDateTime) {
        return Date.from(offsetDateTime.toInstant());
    }

    /**
     * <p> LocalDateTime 转为 Date 表示
     *
     * @param localDateTime
     * @return Date
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
