package com.scau.dao;

import com.scau.entity.*;

import java.util.List;
import java.util.Map;

public interface CheckStatDao {
    List<CheckStat> findAllByPage(Map<String,Integer> map);
    List<CheckStat> findAll();
}
