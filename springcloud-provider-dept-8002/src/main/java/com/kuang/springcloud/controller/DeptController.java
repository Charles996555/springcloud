package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
    *   获取一些配置信息
    * */
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Integer id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.queryAll();
    }

    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> services=client.getServices();
        System.out.println("discover==>services:"+services);

        //得到当前eureka实例
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
            System.out.println(instance.getServiceId());
            System.out.println(instance.getUri());
        }
        return this.client;
    }
}
