package com.scau.service.impl;


import com.scau.dao.SalaryDao;
import com.scau.entity.EmployeeSalary;
import com.scau.service.SalaryService;
import com.scau.util.SQLDateProcessor;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.collections.map.HashedMap;
import org.omg.CORBA.SetOverrideType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryDao salaryDao;
    @Override
    public String findAllByPage(Map<String, Integer> map) {
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> hashMap = new HashMap<>();
        Map<String,Object> jsonMap = new HashMap<String,Object>();


        jsonMap.put("total",list.size());
        jsonMap.put("rows",list);
        String result = JSONObject.fromObject(jsonMap).toString();
        return result;
    }

    @Override
    public String getAllSalary(Map<String,Integer> map) {
        System.out.println("--------service------------");
        List<EmployeeSalary> list = salaryDao.getAllSalary(map);
        System.out.println("fdfd"+list.size());
        List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
        Map<String,Object> hashMap = new HashMap<>();
        for(EmployeeSalary a:list){
            hashMap.put("id",a.getSalary().getId());
            hashMap.put("e_name",a.getEmployee().getE_name());
            hashMap.put("sums",a.getSalary().getSum());
            hashMap.put("dept",a.getJobCategories().getDept());
            hashMap.put("years",a.getCheckStat().getYear());
            hashMap.put("months",a.getCheckStat().getMonth());
            listMap.add(hashMap);
            hashMap = null;
        }
        System.out.println(listMap.toString());System.out.println(listMap);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", list.size());
        jsonMap.put("rows", listMap);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new SQLDateProcessor());
        String result = JSONObject.fromObject(jsonMap, jsonConfig).toString();
        return result;
    }
}
