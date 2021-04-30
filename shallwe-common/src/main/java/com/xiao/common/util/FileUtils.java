package com.xiao.common.util;

import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * @desc: 功能描述：<文件工具类>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/5/1 1:32
 */
public class FileUtils {

    /**
     * 下载文件时，针对不同浏览器，进行附件名的编码
     *
     * @param filename 下载文件名
     * @param agent    客户端浏览器
     * @return 编码后的下载附件名
     * @throws IOException
     */
    public static String encodeDownloadFilename(String filename, String agent)
            throws IOException {
        if (agent.contains("Firefox")) { // 火狐浏览器
            filename = "=?UTF-8?B?"
                    + new BASE64Encoder().encode(filename.getBytes("utf-8"))
                    + "?=";
            filename = filename.replaceAll("\r\n", "");
        } else { // IE及其他浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        }
        return filename;
    }

    /**
     * 根据文件名散列为二级目录
     *
     * @param fileName 文件名
     * @return
     */
    public static String hashRandomDir(String fileName) {
        int hashCode = fileName.hashCode();
        int first = hashCode & 0xf;
        int sec = (hashCode >> 4) & 0xf;
        return "/" + first + "/" + sec;
    }

    /**
     * 获取文件扩展名
     *
     * @param fileName 文件名
     * @return
     */
    public static String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 获取文件的名称
     *
     * @param fileName
     * @return
     */
    public static String getRealName(String fileName) {
        String sepa = System.getProperty("file.separator");
        return fileName.substring(fileName.lastIndexOf(sepa) + 1);
    }

}
