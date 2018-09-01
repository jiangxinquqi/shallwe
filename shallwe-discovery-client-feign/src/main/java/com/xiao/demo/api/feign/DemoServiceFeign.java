package com.xiao.demo.api.feign;


import com.xiao.demo.api.DemoApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @desc: 功能描述：（示例微服务调用客户端）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/8/29 14:24
 */
@FeignClient(value = "SERVICE-DEMO", fallback = DemoServiceHystric.class)
public interface DemoServiceFeign extends DemoApi {

}
