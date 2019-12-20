package com.kuang.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //相当于spring里面的applilcationcontext.xml
    //注册

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
