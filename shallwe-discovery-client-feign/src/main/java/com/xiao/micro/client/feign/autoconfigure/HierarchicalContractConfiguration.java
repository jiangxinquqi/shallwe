package com.xiao.micro.client.feign.autoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HierarchicalContractConfiguration {

    @Bean
    public HierarchicalContract hierarchicalContract() {
        return new HierarchicalContract();
    }

}
