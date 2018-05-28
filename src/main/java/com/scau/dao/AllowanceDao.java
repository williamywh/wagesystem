package com.scau.dao;

import com.scau.entity.*;

import java.util.List;
import java.util.Map;

public interface AllowanceDao {
    List<Allowance> findAllByPage(Map<String,Integer> map);
    List<Allowance> findAll();
}
