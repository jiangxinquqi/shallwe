package com.xiao.common.util;

import sun.misc.BASE64Encoder;

import java.io.*;
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

    /**
     * 二进制文件转为16进制字符串
     *
     * @param file 二进制文件
     * @return 16进制字符串
     */
    public static String binaryFile2HexString(File file) {
        try {
            DataInputStream din = new DataInputStream(new FileInputStream(file));
            StringBuilder hexData = new StringBuilder();
            byte temp = 0;
            for (int i = 0; i < file.length(); i++) {

                temp = din.readByte();

                // 以十六进制的无符号整数形式返回一个字符串表示形式。
                String str = Integer.toHexString(temp);

                if (str.length() == 8) {// 去掉补位的f
                    str = str.substring(6);
                }
                if (str.length() == 1) {
                    str = "0" + str;
                }
                hexData.append(str.toUpperCase());
            }

            din.close();

            return hexData.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 16进制字符串转二进制文件
     *
     * @param hexStr 16进制字符串
     * @param file   二进制文件
     */
    public static void hexString2BinaryFile(String hexStr, File file) {
        try {
            BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(file));
            bof.write(hexStr2Bytes(hexStr));
            bof.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte uniteBytes(String src0, String src1) {
        byte b0 = Byte.decode("0x" + src0).byteValue();
        b0 = (byte) (b0 << 4);
        byte b1 = Byte.decode("0x" + src1).byteValue();
        byte ret = (byte) (b0 | b1);
        return ret;
    }

    private static byte[] hexStr2Bytes(String src) {
        int m = 0, n = 0;
        int l = src.length() / 2;
        //System.out.println(l);
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            m = i * 2 + 1;
            n = m + 1;
            ret[i] = uniteBytes(src.substring(i * 2, m), src.substring(m, n));
        }
        return ret;
    }

}
