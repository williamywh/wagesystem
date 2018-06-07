package com.scau.test.CheckstatTest;

import com.scau.entity.Employee;
import com.scau.entity.EmployeeAttend;
import com.scau.service.CheckStatService;
import com.scau.service.EmployeeService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckstatServiceImplTest extends CheckstatDaoTest{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CheckStatService checkStatService;

    @Test
    public void getAllAttend(){
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("year", 2018);
        map.put("name", "赵红");
        List<EmployeeAttend> list = checkStatService.findAllAttend(map);
        System.out.printf(list.size()+list.toString());
    }

    @Test
    public void update(){
        EmployeeAttend employeeAttend=new EmployeeAttend();
        employeeAttend.setE_name("张三");
        employeeAttend.setAbsent_days(12);
        employeeAttend.setOt_days(23);
        employeeAttend.setLeave_days(22);
        employeeAttend.setWork_days(23);
        employeeAttend.setYear(2018);
        employeeAttend.setMonth(3);
        checkStatService.updateAlltend(employeeAttend);
    }
}
