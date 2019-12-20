package com.kuang.springcloud.conteoller;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerConteoller {

    //消费者里面没有service层，直接使用即可

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX="http://localhost:8001";

    @RequestMapping("consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    @RequestMapping("consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("consumer/dept/get/{id}")
    public Dept queryById(@PathVariable("id")Integer id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get"+id,Dept.class);
    }
}
