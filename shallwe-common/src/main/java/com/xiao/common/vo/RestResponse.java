package com.xiao.common.vo;

import com.xiao.common.constant.RestResponseCodeEnum;
import com.xiao.common.exception.GlobalException;
import lombok.Data;

import java.io.Serializable;

/**
 * @desc: 功能描述：（Json标准视图）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 13:37
 */
@Data
public class RestResponse<T> implements Serializable {

    /**
     * 响应码
     */
    private int code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 业务数据
     */
    private T data;
    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();
    /**
     * 扩展信息
     */
    private Object extraInfo;

    public RestResponse(RestResponseCodeEnum restResponseCodeEnum, T data, Object extraInfo) {
        this.code = restResponseCodeEnum.getCode();
        this.message = restResponseCodeEnum.getMessage();
        this.data = data;
        this.extraInfo = extraInfo;
    }

    public static <T> RestResponse success(T data) {
        return success(data, null);
    }

    public static <T> RestResponse success(T data, Object extraInfo) {
        return new RestResponse(RestResponseCodeEnum.HTTP_RESPONSE_200, data, extraInfo);
    }

    public static <T> RestResponse fail(RestResponseCodeEnum restResponseCodeEnum) {
        return fail(restResponseCodeEnum, null);
    }

    public static <T> RestResponse fail(RestResponseCodeEnum restResponseCodeEnum, Object extraInfo) {
        return new RestResponse(restResponseCodeEnum, null, extraInfo);
    }

    public T parse() {
        return data;
    }

    public T tryParse() {
        if (!isSuccess()) {
            throw new GlobalException(RestResponseCodeEnum.getByCode(code), extraInfo);
        }
        return data;
    }

    public boolean isSuccess() {
        return this.code == RestResponseCodeEnum.HTTP_RESPONSE_200.getCode();
    }
}
