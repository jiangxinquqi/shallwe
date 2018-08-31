package com.xiao.api.feign;

import com.xiao.constant.ServerCode;
import com.xiao.entity.Demo;
import com.xiao.vo.JsonView;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc: 功能描述：（断路由）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/29 14:26
 */
@Component
public class DemoServiceHystric implements DemoServiceFeign {

    @Override
    public JsonView findDemoById(@RequestParam(value = "id", required = true) int id) {
        Demo demo = new Demo();
        // demo.setUrl(request.getRequestURL().toString());
        return new JsonView(ServerCode.SERVER_CODE_500, demo);
    }
}
