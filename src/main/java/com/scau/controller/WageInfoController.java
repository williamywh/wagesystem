package com.scau.controller;


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

@Controller
@RequestMapping("/WageInfo")
public class WageInfoController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/showWageInfo")
    private String WafeInfo(){
        return "other/gradeList";
    }
}
