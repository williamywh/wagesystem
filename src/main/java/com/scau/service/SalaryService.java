package com.scau.service;

import java.util.Map;

public interface SalaryService {
    String findAllByPage(Map<String,Integer> map);
    String getAllSalary(Map<String,Integer> map);
}
