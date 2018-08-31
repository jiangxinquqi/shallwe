package com.xiao.api.controller;

import com.xiao.entity.Demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc: 功能描述：（演示接口）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 13:27
 */
public interface DemoApi {

    @GetMapping("/demo")
    Demo findDemoById(@RequestParam(required = true) Long id);

}
