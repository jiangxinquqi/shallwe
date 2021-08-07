package com.xiao.common.exception;

import com.xiao.common.constant.RestResponseCodeEnum;

/**
 * @desc: 功能描述：（自定义异常）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 13:33
 */
public class GlobalException extends RuntimeException {

    private RestResponseCodeEnum restResponseCodeEnum;

    public GlobalException(RestResponseCodeEnum restResponseCodeEnum) {
        super(restResponseCodeEnum.toString());
        this.restResponseCodeEnum = restResponseCodeEnum;
    }

    public GlobalException(RestResponseCodeEnum restResponseCodeEnum, Object extraInfo) {
        super(restResponseCodeEnum.toString() + ", extraInfo: " + extraInfo);
        this.restResponseCodeEnum = restResponseCodeEnum;
    }

    public RestResponseCodeEnum getRestResponseCodeEnum() {
        return restResponseCodeEnum;
    }

}
