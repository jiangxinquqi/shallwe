package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @desc: 功能描述：（用户微服务）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/1 20:15
 */
@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
