package com.xiao.common.constant;

import com.xiao.common.support.Code;

import java.util.Arrays;

/**
 * @desc: 功能描述：（响应码）
 * @Author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 13:34
 */
public enum RestResponseCodeEnum implements Code<RestResponseCodeEnum> {

    HTTP_RESPONSE_101(101, "微信接口调用异常"),
    HTTP_RESPONSE_200(200, "sucess"),
    HTTP_RESPONSE_400(400, "参数异常，请查看是否正确设置参数值"),
    HTTP_RESPONSE_401(401, "身份认证失败"),
    HTTP_RESPONSE_403(403, "访问受限，该资源仅允许在特定时间或者特定IP段访问"),
    HTTP_RESPONSE_404(404, "访问的资源不存在"),
    HTTP_RESPONSE_500(500, "服务异常");

    private final int code;
    private final String message;

    RestResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestResponseCodeEnum getByCode(int code) {
        RestResponseCodeEnum[] values = RestResponseCodeEnum.values();
        for (RestResponseCodeEnum restResponseCodeEnum : values) {
            if (restResponseCodeEnum.getCode() == code) {
                return restResponseCodeEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
