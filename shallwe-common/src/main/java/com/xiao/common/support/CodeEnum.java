package com.xiao.common.support;

public interface CodeEnum<T> {

    /**
     * 获取枚举值
     *
     * @return 枚举值
     */
    T getCode();
    
    String name();

}
