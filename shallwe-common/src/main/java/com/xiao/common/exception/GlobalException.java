package com.xiao.common.exception;

import com.xiao.common.support.GlobalCode;
import lombok.Getter;

/**
 * @desc: 功能描述：（自定义异常）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 13:33
 */
@Getter
public class GlobalException extends RuntimeException {

    private GlobalCode globalCode;

    private Integer code;
    private String name;
    private String message;
    private String extraInfo;

    public GlobalException(GlobalCode globalCode) {
        this(globalCode, globalCode.getMessage());
    }

    public GlobalException(GlobalCode globalCode, Throwable cause) {
        this(globalCode, cause.getMessage());
    }

    public GlobalException(GlobalCode globalCode, String extraInfo) {
        this(globalCode, extraInfo, null);
    }

    public GlobalException(GlobalCode globalCode, String extraInfo, Throwable cause) {
        this(globalCode.getCode(), globalCode.name(), globalCode.getMessage(), extraInfo, cause);
        this.globalCode = globalCode;
    }

    public GlobalException(Integer code, String name, String message, String extraInfo, Throwable cause) {
        super(String.format("%s{code=%s, message=%s, extraInfo=%s}", name, code, message, extraInfo), cause);
        this.code = code;
        this.name = name;
        this.message = message;
        this.extraInfo = extraInfo;
    }


}
