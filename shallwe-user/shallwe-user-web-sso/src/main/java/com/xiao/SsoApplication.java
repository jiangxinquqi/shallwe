package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @desc: 功能描述：（单点系统启动类）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/1 17:02
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class SsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class, args);
    }
}
