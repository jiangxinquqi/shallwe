package com.xiao.user.web.controller;

import com.alibaba.fastjson.JSON;
import com.xiao.common.util.CookieUtils;
import com.xiao.common.util.StringUtils;
import com.xiao.common.vo.JsonView;
import com.xiao.user.api.feign.UserServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 功能描述：（单点服务）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/1 16:55
 */
@Slf4j
@Controller
public class SsoController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://xiaoxiao.net.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    /**
     * oauth2授权
     *
     * @param request
     * @param appid
     * @param redirect_uri
     * @param response_type
     * @param state
     * @return
     */
    @GetMapping("/authorize")
    public String authorize(HttpServletRequest request,
                            ModelMap map,
                            String appid,
                            String redirect_uri,
                            String response_type,
                            String state) {
        // 判断appid是否在单点授权名单内
        // 判断回调地址合法性
        // 判断响应类型的合法性

        String token = CookieUtils.getCookieValue(request, "token");
        // 判断cookie中是否有token
        if (StringUtils.isEmpty(token)) {
            //如果没有，跳转登录界面，并且设置回调地址
            map.addAttribute("redirect_uri", redirect_uri);
            return "index";
        }
        //如果有，直接将token及code回调
        return "redirect:" + redirect_uri + "?token=" + token + "&state=" + state;
    }

    @PostMapping("/login")
    @ResponseBody
    public JsonView login(HttpServletRequest request, HttpServletResponse response, String username, String password) {
        log.info("username {}:", username);
        log.info("password {}:", password);
        // RPC调用login服务获取token
        JsonView result = userServiceFeign.login(username, password);
        if (result.isSuccess()) {
            String token = result.getData().toString();
            // 设置cookie
            // cookie跨域，cookie有效期
            CookieUtils.setCookie(request, response, "token", token);
        }
        // 返回页面
        return result;
    }

}
