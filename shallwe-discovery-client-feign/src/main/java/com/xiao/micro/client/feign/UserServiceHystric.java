package com.xiao.micro.client.feign;

import com.xiao.common.constant.RestResponseCodeEnum;
import com.xiao.common.vo.RestResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/1 20:27
 */
public class UserServiceHystric implements UserServiceFeign {

    @Override
    public RestResponse register(@RequestBody Object userMock) {
        return fail();
    }

    @Override
    public RestResponse login(String username, String password) {
        return fail();
    }

    @Override
    public RestResponse info(@RequestParam(value = "token") String token) {
        return fail();
    }

    private RestResponse fail() {
        return RestResponse.fail(RestResponseCodeEnum.HTTP_RESPONSE_500);
    }

}
