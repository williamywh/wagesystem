package com.scau.dao;

import com.scau.entity.Employee;
import com.scau.entity.Salary;

import java.util.List;
import java.util.Map;

public interface SalaryDao {
    List<Salary> findAllByPage(Map<String,Integer> map);
    List<Salary> findAll();
}
