package com.xiao.common.util;

import com.xiao.common.support.MessageCodeEnum;
import com.xiao.common.support.CodeEnum;

/**
 * 枚举工具类
 */
public class EnumUtils {

    public static void main(String[] args) {
        try {
            throw new IllegalArgumentException("测试");
        } catch (Exception e) {
            System.out.println("发生异常了");
        }
    }

    public static <T> boolean isExist(CodeEnum<T>[] enums, T code) {

        if (code == null) {
            return false;
        }

        for (CodeEnum<T> e : enums) {
            if (code.equals(e.getCode())) {
                return true;
            }
        }

        return false;

    }

    public static <E extends Enum<? extends CodeEnum<V>>, V> boolean isExist(Class<E> enumClass, V value) {
        for (Enum<? extends CodeEnum<V>> e : enumClass.getEnumConstants()) {
            if (((CodeEnum<V>) e).getCode().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static <T> String getNameByValue(MessageCodeEnum<T>[] enums, T value) {
        if (value == null) {
            return null;
        }
        for (MessageCodeEnum<T> e : enums) {
            if (value.equals(e.getCode())) {
                return e.getMessage();
            }
        }
        return null;
    }

    public static <T> T getValueByName(MessageCodeEnum<T>[] enums, String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (MessageCodeEnum<T> e : enums) {
            if (name.equals(e.getMessage())) {
                return e.getCode();
            }
        }
        return null;
    }

    public static <E extends Enum<? extends CodeEnum<V>>, V> E getEnumByValue(E[] enums, V value) {
        for (E e : enums) {
            if (((CodeEnum<V>) e).getCode().equals(value)) {
                return e;
            }
        }
        return null;
    }

    public static <E extends Enum<? extends CodeEnum<V>>, V> E getEnumByName(Class<E> enumClass, V value) {
        return getEnumByValue(enumClass.getEnumConstants(), value);
    }

}
