package com.xiao.user.dao.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @desc: 功能描述：（模拟用户）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/1 20:13
 */
@Getter
@Setter
public class UserMock {

    private Long id;
    private String username;
    private String password;
    private Date create;
    private Date modified;

    public UserMock(Long id, String username, String password, Date create, Date modified) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.create = create;
        this.modified = modified;
    }
}
