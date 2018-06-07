package com.scau.dao;

import com.scau.entity.*;

import java.util.List;
import java.util.Map;

public interface CheckStatDao {
    List<CheckStat> findAllByPage(Map<String,Integer> map);
    List<EmployeeAttend> findAll(int year,String name);
    Integer getCheckstatNum();
    List<EmployeeAttend> getAllAttendance(Map<String,Integer> map);
    void updateAttendanceByName(CheckStat checkStat);
    List<EmployeeAttend> findAllByName(Map<Object,Object> map);
}
