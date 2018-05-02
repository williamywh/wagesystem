package com.scau.controller;

import com.scau.entity.*;
import com.scau.service.EmployeeService;
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
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
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
        int page = Integer.parseInt(request.getParameter("page"));
        int rows = Integer.parseInt(request.getParameter("rows"));
        String gradeid = request.getParameter("gradeid");
        String clazzid = request.getParameter("clazzid");
        Employee employee = new Employee();
        Map<String,Integer> map = new HashMap<String,Integer>();
        Page pageDomain = new Page(page,rows);
        map.put("start",pageDomain.getStart());
        map.put("size",pageDomain.getSize());
        String result = employeeService.findAllByPage(map);
        System.out.println("result="+result);
        return result;
    }
}
