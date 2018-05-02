package com.scau.util;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filter implements javax.servlet.Filter{
    //读取过滤器配置文件
    private FilterConfig config;
    public void destroy() {
        // TODO Auto-generated method stub
    }
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request=(HttpServletRequest) arg0;
        HttpServletResponse response=(HttpServletResponse) arg1;
        String encoding=config.getInitParameter("encoding");
        if(encoding==null||"".equals(encoding)){
            encoding="utf-8";
        }
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        config=arg0;
    }
}