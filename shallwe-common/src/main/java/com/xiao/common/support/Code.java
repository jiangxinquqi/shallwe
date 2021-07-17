package com.xiao.common.support;

/**
 * @desc: 功能描述：<抽象>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/7/18 1:14
 */
public interface Code<E extends Enum<E>> {

    E getByCode(int code);

    int getCode();

    String getMessage();

}
