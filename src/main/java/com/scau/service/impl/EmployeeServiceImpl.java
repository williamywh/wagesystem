package com.scau.service.impl;

import com.scau.dao.*;
import com.scau.entity.*;
import com.scau.service.*;
import com.scau.util.*;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int e_id) {
        return false;
    }

    @Override
    public Employee findEmployeeById(int e_id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public String findAllByPage(Map<String,Integer> map) {
        List<Employee> list = employeeDao.findAllByPage(map);
        //System.out.println(list.get(0).getDate());
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        jsonMap.put("total",getEmployeeNum());
        jsonMap.put("rows",list);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new SQLDateProcessor());
        String result = JSONObject.fromObject(jsonMap, jsonConfig).toString();
        return result;
    }

    @Override
    public List<Employee> findEmployeeByName(String e_name) {
        return employeeDao.findEmployeeByName(e_name);
    }

    @Override
    public List<Employee> findEmployeeByNameAndDept(Map<String, String> map) {
        return employeeDao.findEmployeeByNameAndDept(map);
    }

    @Override
    public List<Employee> findEmployeeByDept(String dept) {
        return employeeDao.findEmployeeByDept(dept);
    }

    @Override
    public Integer getEmployeeNum() {
        Integer number = employeeDao.getEmployeeNum();
        return number;
    }

}

