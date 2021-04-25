package com.xiao.demo.api.controller;

import com.xiao.demo.api.DemoApi;
import com.xiao.demo.dao.model.Demo;
import com.xiao.common.vo.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 功能描述：（演示服务）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/31 15:01
 */
@RestController
@Slf4j
public class DemoServiceController implements DemoApi {

    @Value("${spring.application.name}")
    private String serverName;
    @Value("${server.port}")
    private String port;

    @Override
    public JsonView findDemoById(@RequestParam(value = "id", required = true) int id) {
        Demo demo = new Demo();
        demo.setId(id);
        //demo.setUrl(request.getRequestURL().toString());
        demo.setServiceName(serverName);
        demo.setPort(port);
        log.trace("");
        log.info("");
        log.debug("");
        log.error("");
        log.warn("");
        return JsonView.sucess(demo);
    }
}
