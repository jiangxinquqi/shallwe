package com.xiao.util;

import java.util.UUID;

/**
 * @desc: 功能描述：（字符串工具类）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 13:09
 */
public class StringUtils {

    /**
     * 功能描述: <生成随机uuid字符串>
     *
     * @Author: jianjun.xiao
     * @Date: 2018/8/31 13:10
     */
    public static String createNonceStr() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

    /**
     * 功能描述: <判断某个字符串是否为null或者为“”>
     *
     * @Author: jianjun.xiao
     * @Date: 2018/8/31 13:11
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

}
