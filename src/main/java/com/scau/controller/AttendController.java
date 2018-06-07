package com.scau.controller;

import com.scau.entity.*;
import com.scau.service.CheckStatService;
import com.scau.service.EmployeeService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/attendInfo")
public class AttendController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CheckStatService checkStatService;

    @RequestMapping(value = "/showList", method = RequestMethod.GET)
    private String showList(Model model) {
        return "other/courseList";
    }

    @RequestMapping(value = "/attendsenList")
    private String attendsenList(Model model) {
        return "other/attendList";
    }

    @RequestMapping(value = "/attendList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    private String attendList(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        System.out.println("-----------------");
        int page = Integer.parseInt(request.getParameter("page"));
        int rows = Integer.parseInt(request.getParameter("rows"));
        Map<String,Integer> map = new HashMap<String,Integer>();
        Page pageDomain = new Page(page,rows);
        map.put("start",pageDomain.getStart());
        map.put("size",pageDomain.getSize());
        String result = checkStatService.getAllAttend(map);
        System.out.println("result="+result);
        return result;
    }

    @RequestMapping(value = "/addAttend", method = RequestMethod.POST)
    @ResponseBody
    private String addAttend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> pNames = request.getParameterNames();
        Map<String,String> map = new HashMap<String,String>();
        while(pNames.hasMoreElements()){
            String pName = pNames.nextElement();
            String value = request.getParameter(pName);
            map.put(pName,value);
        }
        EmployeeAttend employeeAttend=new EmployeeAttend();
        employeeAttend.setE_name(map.get("e_name"));
        employeeAttend.setLeave_days(Integer.parseInt(map.get("leave_days")));
        employeeAttend.setWork_days(Integer.parseInt(map.get("work_days")));
        employeeAttend.setOt_days(Integer.parseInt(map.get("ot_days")));
        employeeAttend.setAbsent_days(Integer.parseInt(map.get("absent_days")));
        employeeAttend.setMonth(Integer.parseInt(map.get("month")));
        employeeAttend.setYear(Integer.parseInt(map.get("year")));
        System.out.println(employeeAttend.toString());
        checkStatService.updateAlltend(employeeAttend);
        return "success";
    }

    @RequestMapping(value = "/statisticalList", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    private String statisticalList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Enumeration<String> pNames = request.getParameterNames();
        Map<String,String> map = new HashMap<String,String>();
        while(pNames.hasMoreElements()){
            String pName = pNames.nextElement();
            String value = request.getParameter(pName);
            map.put(pName,value);
        }
//        System.out.println(map);
        if((map.get("e_name")!=null)){
            CheckStat checkStat=new CheckStat();
            int year=Integer.parseInt(map.get("year"));
            String name=map.get("e_name");
            System.out.println(name);
            Map<Object, Object> maplist = new HashMap<Object, Object>();
            maplist.put("year", year);
            maplist.put("name", name);
            List<EmployeeAttend> checkstat = checkStatService.findAllAttend(maplist);
            JsonConfig config = new JsonConfig();
            String result1 = JSONArray.fromObject(checkstat,config).toString();
            System.out.println("result1="+result1);
            return result1;
        }else return null;
    }

}
