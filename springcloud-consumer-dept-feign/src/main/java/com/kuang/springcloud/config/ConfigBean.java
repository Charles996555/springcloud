package com.kuang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //相当于spring里面的applilcationcontext.xml
    //注册
    /**
    *   相当于spring里面的applilcationcontext.xml
    *   注册
    *   @LoadBalance相当于负载均衡Ribbon
    * */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
