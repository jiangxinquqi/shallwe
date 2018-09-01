package com.xiao.common.exception;

import com.xiao.common.constant.ServerCode;

/**
 * @desc: 功能描述：（自定义异常）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 13:33
 */
public class ShallweException extends Exception {

    private ServerCode serverCode;

    public ShallweException(ServerCode serverCode, String errmsg) {
        super(errmsg);
        this.serverCode = serverCode;
    }

    public ShallweException(String message) {
        super(message);
    }

    public ServerCode getServerCode() {
        return this.serverCode;
    }

}
