package com.xiao.micro.client.feign;


import com.xiao.micro.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/1 20:26
 */
@FeignClient(value = "micro-service-user", fallback = UserServiceHystric.class)
public interface UserServiceFeign extends UserApi {
}
