package com.xiao.config.web;

import com.xiao.common.constant.RestResponseCodeEnum;
import com.xiao.common.exception.GlobalException;
import com.xiao.common.vo.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @desc: 功能描述：<全局异常处理器>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/8/7 19:07
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    public RestResponse han(GlobalException globalException) {
        // log.error("GlobalException：", globalException);
        return RestResponse.fail(globalException.getRestResponseCodeEnum(), globalException.getExtraInfo());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public RestResponse handleException(Exception e) {
        log.error("exception：", e);
        return RestResponse.fail(RestResponseCodeEnum.HTTP_RESPONSE_500, e);
    }

}
