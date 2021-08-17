package com.xiao.micro.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户服务
 * <p>
 *
 * @author： jianjun.xiao
 * @e-mail： xiaocen65535@163.com
 * @date： 2021/8/13 10:15
 */
@RestController
public class UserController {

    @GetMapping("test")
    public String test() {
        return "测试成功";
    }

}
