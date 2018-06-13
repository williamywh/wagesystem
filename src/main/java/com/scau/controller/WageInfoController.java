package com.scau.controller;


import com.scau.entity.*;
import com.scau.service.*;
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
import java.util.*;

@Controller
@RequestMapping("/WageInfo")
public class WageInfoController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SalaryService salaryService;


    @RequestMapping(value = "/showWageInfo")
    private String WafeInfo(){
        return "other/gradeList";
    }

    @RequestMapping(value = "/salaryList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    private String salaryList(HttpServletRequest request, HttpServletResponse response,Model model) throws ServletException, IOException {
//        System.out.println("***************");
        int page = Integer.parseInt(request.getParameter("page"));
        int rows = Integer.parseInt(request.getParameter("rows"));
//        System.out.println("page="+page+"rows="+rows);
        Map<String,Integer> map = new HashMap<String,Integer>();
        Page pageDomain = new Page(page,rows);
        map.put("start",pageDomain.getStart());
        map.put("size",pageDomain.getSize());
        String result = salaryService.getAllSalary(map);
        System.out.println("result="+result);
        return result;
    }
}
