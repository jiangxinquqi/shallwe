package com.xiao.common.support;

/**
 * @desc: 功能描述：<抽象>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/7/18 1:14
 */
public interface GlobalCode<E extends Enum<E>> {

    int getCode();

    String getMessage();

}
