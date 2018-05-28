package com.scau.service.impl;


import com.scau.dao.SalaryDao;
import com.scau.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryDao salaryDao;
    @Override
    public String findAllByPage(Map<String, Integer> map) {
        return null;
    }
}
