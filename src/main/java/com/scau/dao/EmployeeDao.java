package com.scau.dao;

import java.util.*;

import com.scau.entity.Employee;

public interface EmployeeDao {
    // EmployeeDao 表
    void insertEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int e_id);
    Employee findEmployeeById(int e_id);
    List<Employee> findAll();
    List<Employee> findAllByPage(Map<String,Integer> map);
    List<Employee> findEmployeeByName(String e_name);
    List<Employee> findEmployeeByNameAndDept(Map<String, String> map);
    List<Employee> findEmployeeByDept(String dept);
    Integer getEmployeeNum();
    int getE_id(String name);
}
