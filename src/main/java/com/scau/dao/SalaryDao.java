package com.scau.dao;

import com.scau.entity.*;

import java.util.List;
import java.util.Map;

public interface SalaryDao {
    List<Salary> findAllByPage(Map<String,Integer> map);
    List<Salary> findAll();
    List<EmployeeSalary> getAllSalary(Map<String,Integer> map);
}
