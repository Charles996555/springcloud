package com.kuang.springcloud.conteoller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptClientService;
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
    private DeptClientService service = null;

    @RequestMapping("consumer/dept/list")
    public List<Dept> list(){
        return service.queryAll();
    }

    @RequestMapping("consumer/dept/add")
    public boolean add(Dept dept){
        return service.addDept(dept);
    }

    @RequestMapping("consumer/dept/get/{id}")
    public Dept queryById(@PathVariable("id")Integer id){
        return (Dept) service.queryById(id);
    }
}
