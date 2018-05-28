package com.scau.dao;

import com.scau.entity.*;

import java.util.List;
import java.util.Map;

public interface Check_allowDao {
    List<Check_allow> findAllByPage(Map<String,Integer> map);
    List<Check_allow> findAll();
}
