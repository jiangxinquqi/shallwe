package com.xiao.user.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @desc: 功能描述：（单点服务）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/1 16:55
 */
@Controller
public class SsoController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://xiaoxiao.net.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
