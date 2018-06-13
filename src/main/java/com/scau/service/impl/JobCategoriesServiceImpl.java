package com.scau.service.impl;

import com.scau.dao.*;
import com.scau.entity.*;
import com.scau.service.*;
import com.scau.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;

@Service
public class JobCategoriesServiceImpl implements JobCategoriesService{

    @Autowired
    private JobCategoriesDao jobCategoriesDao;

    @Override
    public List<JobCategories> findAllDept() {
        return jobCategoriesDao.findAllDept();

    }
    @Override
    public String findJobCategoriesDept() {
        List<JobCategories> list = jobCategoriesDao.findJobCategoriesDept();
        //Map<String,Object> jsonMap = new HashMap<String,Object>();
        JsonConfig config = new JsonConfig();
        config.setExcludes(new String[]{"classn","base_wage","title"});
        //jsonMap.put("name",list);
        String result = JSONArray.fromObject(list,config).toString();
        return result;
    }

    @Override
    public String findJobCategoriesClassn() {
        List<JobCategories> list = jobCategoriesDao.findJobCategoriesClassn();
        //Map<String,Object> jsonMap = new HashMap<String,Object>();
        JsonConfig config = new JsonConfig();
        config.setExcludes(new String[]{"dept","base_wage","title"});
        //jsonMap.put("name",list);
        String result = JSONArray.fromObject(list,config).toString();
        return result;
    }

    @Override
    public void insertJobCategories(JobCategories jobCategories) {
        jobCategoriesDao.insertJobCategories(jobCategories);
    }


}
