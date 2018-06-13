<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
    <%--pageEncoding="UTF-8"%>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<% String appPath = request.getContextPath(); %>--%>
<%--<html>--%>
<%--<head>--%>
<%--<meta charset="utf-8">--%>
<%--<meta name="renderer" content="webkit|ie-comp|ie-stand">--%>
<%--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">--%>
<%--<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />--%>
<%--<meta http-equiv="Cache-Control" content="no-siteapp" />--%>
<%--<link rel="shortcut icon" href="favicon.ico"/>--%>
<%--<link rel="bookmark" href="favicon.ico"/>--%>
<%--<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />--%>
<%--<link href="static/h-ui/css/H-ui.login.css" rel="stylesheet" type="text/css" />--%>
<%--<link href="static/h-ui/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />--%>
<%--<link href="static/h-ui/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />--%>

<%--<link rel="stylesheet" type="text/css" href="static/easyui/themes/default/easyui.css">--%>
<%--<link rel="stylesheet" type="text/css" href="static/easyui/themes/icon.css">--%>

<%--<script type="text/javascript" src="static/easyui/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>--%>
<%--<script type="text/javascript" src="static/h-ui/lib/icheck/jquery.icheck.min.js"></script>--%>

<%--<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>--%>

<%--<title>登录|工资管理系统</title>--%>
<%--<meta name="keywords" content="工资管理系统">--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="header" style="padding: 0;">--%>
	<%--<h2 style="color: white; width: 400px; height: 60px; line-height: 60px; margin: 0 0 0 30px; padding: 0;">工资管理系统</h2>--%>
<%--</div>--%>
<%--<div class="loginWraper">--%>
  <%--<div id="loginform" class="loginBox">--%>
    <%--<form id="form" action="employee/login" class="form form-horizontal" method="post">--%>
      <%--<div class="row cl">--%>
        <%--<label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>--%>
        <%--<div class="formControls col-8">--%>
          <%--<input id="" name="account" type="text" placeholder="账户" class="input-text size-L">--%>
        <%--</div>--%>
      <%--</div>--%>
      <%--<div class="row cl">--%>
        <%--<label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>--%>
        <%--<div class="formControls col-8">--%>
          <%--<input id="" name="password" type="password" placeholder="密码" class="input-text size-L">--%>
        <%--</div>--%>
      <%--</div>--%>
      <%--<div class="row cl">--%>
        <%--<div class="formControls col-8 col-offset-3">--%>
          <%--<input class="input-text size-L" name="vcode" type="text" placeholder="请输入验证码" style="width: 200px;">--%>
          <%--<img title="点击图片切换验证码" id="vcodeImg" src="LoginServlet?method=GetVCode"></div>--%>
      <%--</div>--%>

      <%--<div class="mt-20 skin-minimal" style="text-align: center;">--%>
		<%--<div class="radio-box">--%>
			<%--<input type="radio" id="radio-2" name="type" checked value="2" />--%>
			<%--<label for="radio-1">员工</label>--%>
		<%--</div>--%>
		<%--<div class="radio-box">--%>
			<%--<input type="radio" id="radio-3" name="type" value="3" />--%>
			<%--<label for="radio-2">管理员1</label>--%>
		<%--</div>--%>
		<%--<div class="radio-box">--%>
			<%--<input type="radio" id="radio-1" name="type" value="1" />--%>
			<%--<label for="radio-3">管理员2</label>--%>
		<%--</div>--%>
	<%--</div>--%>

      <%--<div class="row">--%>
        <%--<div class="formControls col-8 col-offset-3">--%>
          <%--<!--<input id="submitBtn" type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">-->--%>
          <%--<input type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;" >--%>
        <%--</div>--%>
      <%--</div>--%>
    <%--</form>--%>
  <%--</div>--%>
<%--</div>--%>
<%--<div class="footer">Copyright &nbsp; scau </div>--%>


<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<html>
<html>
<head>
    <title>页面重定向</title>
</head>
<body>

<h1>页面重定向</h1>

<%
    String site = new String("/wagesystem/employee/login");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>

</body>
</html>