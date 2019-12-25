package com.kuang.springcloud.dao;


import com.kuang.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);
    public Dept queryById(Integer id);
    public List<Dept> queryAll();
}
