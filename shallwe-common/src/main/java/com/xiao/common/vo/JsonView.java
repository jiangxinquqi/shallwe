package com.xiao.common.vo;

import com.xiao.common.constant.ServerCode;

import java.io.Serializable;

/**
 * @desc: 功能描述：（Json标准视图）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 13:37
 */
public class JsonView implements Serializable {

    public int code;

    public String msg;

    public Object data;

    public JsonView() {
    }

    public JsonView(ServerCode serverCode, Object data) {
        this.code = serverCode.getCode();
        this.msg = serverCode.getMsg();
        this.data = data;
    }

    public JsonView(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static JsonView sucess(Object data) {
        return new JsonView(ServerCode.SERVER_CODE_200, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
