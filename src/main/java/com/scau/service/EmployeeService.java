package com.scau.service;

import com.scau.entity.*;
import java.util.*;

public interface EmployeeService {
    void insertEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int e_id);
    Employee findEmployeeById(int e_id);
    List<Employee> findAll();
    String findAllByPage(Map<String,Integer> map);
    Employee findEmployeeByName(String e_name);
    Integer getEmployeeNum();
}
