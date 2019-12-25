package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author: 张雨潇
 * @Date: 2019/12/24 16:51
 */

@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
@Service
public interface DeptClientService {
    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Integer id);

    @GetMapping("/dept/list")
    public List<Dept> queryAll();

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);
}
