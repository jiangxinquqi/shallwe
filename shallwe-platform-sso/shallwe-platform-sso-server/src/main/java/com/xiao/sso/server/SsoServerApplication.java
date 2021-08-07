package com.xiao.sso.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @desc: 功能描述：<单点服务端>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/8/7 9:44
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class SsoServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoServerApplication.class, args);
    }
}
