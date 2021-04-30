package com.xiao.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc: 功能描述：<IP工具类>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/5/1 1:12
 */
public class IPUtils {

    /**
     * 获取客户端真实IP地址
     *
     * @param request http请求
     * @return ip地址
     */
    public static String getIpAddress(HttpServletRequest request) {

        // Nginx代理一般会加上此请求头。
        String Xip = request.getHeader("X-Real-IP");
        // 这是一个Squid开发的字段，只有在通过了HTTP代理或者负载均衡服务器时才会添加该项
        String XFor = request.getHeader("X-Forwarded-For");

        if (!StringUtils.isNullOrEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if (index != -1) {
                return XFor.substring(0, index);
            } else {
                return XFor;
            }
        }
        XFor = Xip;
        if (!StringUtils.isNullOrEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            return XFor;
        }
        if (StringUtils.isNullOrEmpty(XFor.trim()) || "unknown".equalsIgnoreCase(XFor)) {
            // apache http做代理时一般会加上Proxy-Client-IP请求头
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isNullOrEmpty(XFor.trim()) || "unknown".equalsIgnoreCase(XFor)) {
            // WL-Proxy-Client-IP是 pache http代理 的weblogic插件加上的头。
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isNullOrEmpty(XFor.trim()) || "unknown".equalsIgnoreCase(XFor)) {
            // 有些代理服务器会加上此请求头
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isNullOrEmpty(XFor.trim()) || "unknown".equalsIgnoreCase(XFor)) {
            // 简称XFF头，它代表客户端，也就是HTTP的请求端真实的IP，
            // 只有在通过了HTTP 代理(比如APACHE代理)或者负载均衡服务器时才会添加该项。
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isNullOrEmpty(XFor.trim()) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }

}
