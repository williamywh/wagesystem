package com.scau.controller;

import com.scau.entity.*;
import com.scau.service.EmployeeService;
import com.scau.util.SQLDateProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String admin(Model model) {
        return "admin/admin";
    }

    @RequestMapping(value = "/examList")
    private String examList(Model model) {
        return "other/examList";
    }

    @RequestMapping(value = "/employeeInfoStart", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    private String startInfo(HttpServletRequest request, HttpServletResponse response,Model model) throws ServletException, IOException {
        Enumeration<String> pNames = request.getParameterNames();
        Map<String,String> map1 = new HashMap<String,String>();
        while(pNames.hasMoreElements()){
            String pName = pNames.nextElement();
            String value = request.getParameter(pName);
            map1.put(pName,value);
        }
        if((map1.get("e_name")==null&&map1.get("department")==null) || (map1.get("e_name")==""&& (map1.get("department").equals("不限")||map1.get("department")==""))){
            int page = Integer.parseInt(request.getParameter("page"));
            int rows = Integer.parseInt(request.getParameter("rows"));
            String gradeid = request.getParameter("gradeid");
            String clazzid = request.getParameter("clazzid");
            Employee employee = new Employee();
            Map<String, Integer> map = new HashMap<String, Integer>();
            Page pageDomain = new Page(page, rows);
            map.put("start", pageDomain.getStart());
            map.put("size", pageDomain.getSize());
            String result = employeeService.findAllByPage(map);
//            System.out.println("result=" + result);
            return result;
        }else {
            String name= map1.get("e_name");
            String department = map1.get("department");
            List<Employee> employees = null;
            if(department.equals("不限")){
                employees=employeeService.findEmployeeByName(name);
            }else if(name==""){
                employees=employeeService.findEmployeeByDept(department);
            }
            else{
                Map<String,String> mapp = new HashMap<String, String>();
                mapp.put("e_name",name);
                mapp.put("dept",department);
                employees=employeeService.findEmployeeByNameAndDept(mapp);
            }
            if(employees.size()!=0) {
                Map<String, Object> jsonMap = new HashMap<String, Object>();
                jsonMap.put("total", 1);
                jsonMap.put("rows", employees);
                JsonConfig jsonConfig = new JsonConfig();
                jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new SQLDateProcessor());
                String result1 = JSONObject.fromObject(jsonMap, jsonConfig).toString();
//                System.out.println(result1);
                return result1;
            }else {
                Map<String, Object> jsonMap = new HashMap<String, Object>();
                jsonMap.put("total", 0);
                jsonMap.put("rows", 0);
                JsonConfig jsonConfig = new JsonConfig();
                jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new SQLDateProcessor());
                String result1 = JSONObject.fromObject(jsonMap, jsonConfig).toString();
                //System.out.println(result1);
                return result1;
            }
        }
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    private String findByName(HttpServletRequest request, HttpServletResponse response,Model model) throws ServletException, IOException {
        Enumeration<String> pNames = request.getParameterNames();
        Map<String,String> map = new HashMap<String,String>();
        while(pNames.hasMoreElements()){
            String pName = pNames.nextElement();
            String value = request.getParameter(pName);
            map.put(pName,value);
        }
        System.out.println("result1="+(map.get("e_name")));
        if((map.get("e_name")!=null)){
            System.out.println("result1="+(map.get("e_name")));
            return "success";
        }else return null;
    }
}
