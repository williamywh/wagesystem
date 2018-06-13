package com.scau.test;

import com.scau.entity.Employee;
import com.scau.service.EmployeeService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImplTest extends EmployeeDaoTest{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void findEmployeeByName1(){
        List<Employee> employee = employeeService.findEmployeeByName("张三");
//        System.out.printf(employee.toString());
    }


}
