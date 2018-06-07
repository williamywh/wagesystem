package com.scau.controller;


import com.scau.entity.Emp_jobc;
import com.scau.entity.Employee;
import com.scau.entity.JobCategories;
import com.scau.entity.Page;
import com.scau.service.*;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/jobcategories")
public class JobCategoriesController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JobCategoriesService jobCategoriesService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Emp_jobcService emp_jobcService;

    @RequestMapping(value = "/deptList")
    private String deptList(Model model) {
        return "other/dept";
    }

    @RequestMapping(value = "/allDept", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    private String allDept(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        List<JobCategories> result = jobCategoriesService.findAllDept();
        JsonConfig config = new JsonConfig();
        String result1 = JSONArray.fromObject(result,config).toString();
        System.out.println("result1="+result1);
        return result1;
    }

    @RequestMapping(value = "/jobcategoriesDept", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    private String DeptList(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        String result = jobCategoriesService.findJobCategoriesDept();
        System.out.println("DeptList="+result);
        return result;
    }

    @RequestMapping(value = "/jobcategoriesClassn", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    private String ClassnList(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        String result = jobCategoriesService.findJobCategoriesClassn();
        System.out.println("ClassnList="+result);
        return result;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    @ResponseBody
    private String addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> pNames = request.getParameterNames();
        Map<String,String> map = new HashMap<String,String>();
        while(pNames.hasMoreElements()){
            String pName = pNames.nextElement();
            String value = request.getParameter(pName);
            map.put(pName,value);
        }
        System.out.println(map);
        Employee employee = new Employee(map.get("e_name"),map.get("gender"),map.get("tel"),map.get("address"),"111111",
                                            "",java.sql.Date.valueOf(map.get("datetime")));
        JobCategories jobCategories = new JobCategories(map.get("title"),map.get("dept"),Integer.parseInt(map.get("base_wage")),map.get("classn"));
        try{
            jobCategoriesService.insertJobCategories(jobCategories);
            employeeService.insertEmployee(employee);
            Emp_jobc emp_jobc = new Emp_jobc(employee.getE_id(),jobCategories.getJ_id());
            emp_jobcService.insertEmp_jobc(emp_jobc);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    @ResponseBody
    private String addDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> pNames = request.getParameterNames();
        Map<String,String> map = new HashMap<String,String>();
        while(pNames.hasMoreElements()){
            String pName = pNames.nextElement();
            String value = request.getParameter(pName);
            map.put(pName,value);
        }
        System.out.println(map);
        JobCategories jobCategories=new JobCategories();
        jobCategories.setDept(map.get("name"));
        jobCategories.setTitle("默认");
        jobCategories.setBase_wage(0);
        jobCategories.setClassn("默认");
        try{
            jobCategoriesService.insertJobCategories(jobCategories);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
