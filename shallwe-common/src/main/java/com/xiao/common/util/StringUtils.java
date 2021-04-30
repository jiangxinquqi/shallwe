package com.xiao.common.util;

import java.util.UUID;

/**
 * @desc: 功能描述：（字符串工具类）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 13:09
 */
public class StringUtils {

    /**
     * 功能描述: <生成随机16位大写字符>
     *
     * @Author: jianjun.xiao
     * @Date: 2018/8/31 13:10
     */
    public static String nonStr() {
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }

    /**
     * 功能描述: <生成随机uuid字符串>
     *
     * @Author: jianjun.xiao
     * @Date: 2018/8/31 13:10
     */
    public static String UUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 功能描述: <生成随机uuid大写字符串>
     *
     * @Author: jianjun.xiao
     * @Date: 2018/8/31 13:10
     */
    public static String UUID2UpperCase() {
        return UUID().toUpperCase();
    }

    /**
     * 功能描述: <判断某个字符串是否为 null 或者 为"">
     *
     * @Author: jianjun.xiao
     * @Date: 2018/8/31 13:11
     */
    public static boolean isNullOrEmpty(String str) {
        return (str == null || "".equals(str));
    }

    /**
     * <p>判断字符串 不为null & "" </>
     *
     * @param str
     * @return
     */
    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }

}
