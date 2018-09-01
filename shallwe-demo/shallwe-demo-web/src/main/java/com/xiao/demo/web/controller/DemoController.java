package com.xiao.demo.web.controller;

import com.xiao.api.feign.DemoServiceFeign;
import com.xiao.common.vo.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc: 功能描述：（演示web应用调用服务）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 15:20
 */
@RestController
public class DemoController {

    @Autowired
    private DemoServiceFeign demoServiceFeign;

    @GetMapping("/web/demo")
    public JsonView demo(int id) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String name = request.getParameter("name");
        System.out.println(name);
        return demoServiceFeign.findDemoById(id);
    }

}
