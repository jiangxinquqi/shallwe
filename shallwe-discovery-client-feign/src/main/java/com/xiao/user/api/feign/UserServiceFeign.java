package com.xiao.user.api.feign;

import com.xiao.demo.api.feign.DemoServiceHystric;
import com.xiao.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/1 20:26
 */
@FeignClient(value = "SERVICE-USER", fallback = UserServiceHystric.class)
public interface UserServiceFeign extends UserApi {
}
