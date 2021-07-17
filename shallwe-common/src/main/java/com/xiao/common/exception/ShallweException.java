package com.xiao.common.exception;

import com.xiao.common.constant.RestResponseCodeEnum;

/**
 * @desc: 功能描述：（自定义异常）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 13:33
 */
public class ShallweException extends Exception {

    private RestResponseCodeEnum restResponseCodeEnum;

    public ShallweException(RestResponseCodeEnum restResponseCodeEnum, String errmsg) {
        super(errmsg);
        this.restResponseCodeEnum = restResponseCodeEnum;
    }

    public ShallweException(String message) {
        super(message);
    }

    public RestResponseCodeEnum getServerCode() {
        return this.restResponseCodeEnum;
    }

}
