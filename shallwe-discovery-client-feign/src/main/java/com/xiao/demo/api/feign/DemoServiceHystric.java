package com.xiao.demo.api.feign;

import com.xiao.common.constant.RestResponseCodeEnum;

import com.xiao.common.vo.RestResponse;
import com.xiao.demo.dao.model.Demo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc: 功能描述：（断路由）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/29 14:26
 */
@Component
public class DemoServiceHystric implements DemoServiceFeign {
    @Override
    public RestResponse findDemoById(@RequestParam(value = "id", required = true) int id) {
        Demo demo = new Demo();
        // demo.setUrl(request.getRequestURL().toString());
        return new RestResponse(RestResponseCodeEnum.SERVER_CODE_500, demo);
    }
}
