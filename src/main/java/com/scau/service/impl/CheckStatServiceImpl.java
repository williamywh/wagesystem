package com.scau.service.impl;

import com.scau.dao.CheckStatDao;
import com.scau.dao.EmployeeDao;
import com.scau.entity.*;
import com.scau.service.CheckStatService;
import com.scau.util.SQLDateProcessor;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckStatServiceImpl implements CheckStatService {
    @Autowired
    private CheckStatDao checkStatDao;

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public String findAllByPage(Map<String,Integer> map) {
        List<CheckStat> list = checkStatDao.findAllByPage(map);
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
    public Integer getEmployeeNum() {
        Integer number = checkStatDao.getCheckstatNum();
        return number;
    }

    @Override
    public String getAllAttend(Map<String, Integer> map) {
        System.out.println("--------serviceff------------");
        List<EmployeeAttend> list = checkStatDao.getAllAttendance(map);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", getEmployeeNum());
        jsonMap.put("rows", list);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new SQLDateProcessor());
        String result = JSONObject.fromObject(jsonMap, jsonConfig).toString();
        return result;
    }

    @Override
    public List<EmployeeAttend> findAllAttend(Map<Object,Object> map) {
        return checkStatDao.findAllByName(map);
    }

    @Override
    public void updateAlltend(EmployeeAttend employeeAttend) {
        int e_id=employeeDao.getE_id(employeeAttend.getE_name());
        CheckStat checkStat=new CheckStat(e_id,employeeAttend.getOt_days(),employeeAttend.getAbsent_days(),
                employeeAttend.getLeave_days(),employeeAttend.getYear(),employeeAttend.getMonth(),employeeAttend.getWork_days());
//        System.out.println(checkStat.toString());
        checkStatDao.updateAttendanceByName(checkStat);
    }
}
