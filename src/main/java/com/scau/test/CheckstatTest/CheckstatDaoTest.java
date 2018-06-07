package com.scau.test.CheckstatTest;

import com.scau.dao.*;
import com.scau.entity.*;
import com.scau.test.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.tags.form.CheckboxesTag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckstatDaoTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CheckStatDao checkStatDao;

    @Test
    public void findAllByPage() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("start", 0);
        map.put("size", 2);
        List<CheckStat> list = checkStatDao.findAllByPage(map);
        System.out.println(list.size());
    }

//    @Test
//    public void findAll() {
//        List<EmployeeAttend> list = checkStatDao.findAll(2018,"赵红");
//        System.out.println(list.size());
//        System.out.println(list.get(0).toString());
//    }

    @Test
    public void getnumber(){
        Integer num=checkStatDao.getCheckstatNum();
        System.out.println(num);
    }

    @Test
    public void getallAttend(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("start", 0);
        map.put("size", 2);
        List<EmployeeAttend> num=checkStatDao.getAllAttendance(map);
        System.out.println(num);
    }

    @Test
    public void update(){
        CheckStat checkStat=new CheckStat();
        checkStat.setE_id(116);
        checkStat.setOt_days(13);
        checkStat.setAbsent_days(12);
        checkStat.setLeave_days(13);
        checkStat.setWork_days(20);
        checkStat.setMonth(5);
        checkStat.setYear(2018);
        checkStatDao.updateAttendanceByName(checkStat);
//        checkStatDao.getAllAttendance(map);
//        System.out.println(num);
    }

    @Test
    public void findByName(){
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("year", 2018);
        map.put("name", "赵红");
        List<EmployeeAttend> num=checkStatDao.findAllByName(map);
        System.out.println(num.size());
        System.out.println(num);
    }
}
