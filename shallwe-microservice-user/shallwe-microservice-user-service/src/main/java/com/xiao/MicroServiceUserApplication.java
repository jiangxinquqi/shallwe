package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @desc: 功能描述：<用户微服务>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/8/8 23:37
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceUserApplication.class, args);
    }
}
