package com.scau.controller;


import com.scau.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping(value = "/showWageInfo")
    private String WafeInfo(){
        return "other/gradeList";
    }

    @RequestMapping(value = "/salaryList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    private String salaryList(HttpServletRequest request, HttpServletResponse response,Model model) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int rows = Integer.parseInt(request.getParameter("rows"));
        String gradeid = request.getParameter("gradeid");
        String clazzid = request.getParameter("clazzid");
        Employee employee = new Employee();
        Map<String,Integer> map = new HashMap<String,Integer>();
        Page pageDomain = new Page(page,rows);
        map.put("start",pageDomain.getStart());
        map.put("size",pageDomain.getSize());
        return null;
    }
}
