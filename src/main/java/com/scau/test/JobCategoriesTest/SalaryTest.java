package com.scau.test.JobCategoriesTest;


import com.scau.dao.SalaryDao;
import com.scau.entity.*;
import com.scau.test.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalaryTest extends BaseTest{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SalaryDao salaryDao;

    @Test
    public void findAllByPage() {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("start",0);
        map.put("size",2);
        List<Salary> list = salaryDao.findAllByPage(map);
        System.out.println(list.size());
    }
    @Test
    public void findAll() {
        List<Salary> employee = salaryDao.findAll();
        System.out.println(employee.size());
        System.out.println(employee.get(0).toString());
    }

    @Test
    public void getAllSalary() {
//        List<EmployeeSalary> list = salaryDao.getAllSalary();
//        System.out.println(list.get(0).toString());
    }
}
