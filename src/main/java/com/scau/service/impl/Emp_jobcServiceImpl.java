package com.scau.service.impl;

import com.scau.dao.Emp_jobcDao;
import com.scau.entity.Emp_jobc;
import com.scau.service.Emp_jobcService;
import com.scau.service.JobCategoriesService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Emp_jobcServiceImpl implements Emp_jobcService {

    @Autowired
    private Emp_jobcDao emp_jobcDao;

    @Override
    public void insertEmp_jobc(Emp_jobc emp_jobc) {
        emp_jobcDao.insertEmp_jobc(emp_jobc);
    }
}