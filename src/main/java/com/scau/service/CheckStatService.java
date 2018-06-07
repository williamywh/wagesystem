package com.scau.service;

import com.scau.entity.CheckStat;
import com.scau.entity.EmployeeAttend;

import java.util.List;
import java.util.Map;

public interface CheckStatService {
    String findAllByPage(Map<String,Integer> map);
    Integer getEmployeeNum();
    String getAllAttend(Map<String,Integer> map);
    List<EmployeeAttend> findAllAttend(Map<Object,Object> map);
    void updateAlltend(EmployeeAttend employeeAttend);
}
