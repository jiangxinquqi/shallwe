package com.xiao.user.dao.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @desc: 功能描述：（用户实体）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/2 9:13
 */
@Setter
@Getter
public class User {

    private Long id;
    private String phone;
    private String username;
    private String password;

}
