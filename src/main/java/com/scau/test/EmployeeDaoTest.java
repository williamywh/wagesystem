package com.scau.test;
import com.scau.dao.EmployeeDao;
import com.scau.dao.SalaryDao;
import com.scau.entity.*;
import java.util.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class EmployeeDaoTest extends BaseTest{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private SalaryDao salaryDao;

    @Test
    public void findEmployeeById() {
        Employee employee = employeeDao.findEmployeeById(1);
        //System.out.println(employee.toString());
    }

    @Test
    public void findAll() {
        List<Employee> employee = employeeDao.findAll();
        //System.out.println(employee.size());
        //System.out.println(employee.get(1).toString());
    }

    @Test
    public void findEmployeeByName() {
        List<Employee> employee = employeeDao.findEmployeeByName("赵燕");
//        System.out.println(employeeDao.findEmployeeByName("赵燕"));
        //System.out.println(employee.toString());
    }

    @Test
    public void findAllByPage() {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("start",1);
        map.put("size",10);
        List<Employee> list = employeeDao.findAllByPage(map);
        //System.out.println(list.size());
    }

    @Test
    public void insertEmployee(){
        long time = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(time);
        Employee employee = new Employee("赵燕g","男","15975326485","东莞","111111","Test",date);
        employeeDao.insertEmployee(employee);
//        System.out.println(employee.getE_id());
    }

    @Test
    public void findE_id(){
        String name="张三";
        int id=employeeDao.getE_id(name);
//        System.out.println(id);
    }
    @Test
    public void getNum(){
//        System.out.println(employeeDao.getEmployeeNum());
    }
    @Test
    public void getAllSalary(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("start",0);
        map.put("size",50);
        List<EmployeeSalary> list = salaryDao.getAllSalary(map);
        System.out.println(list.size());
    }
}
