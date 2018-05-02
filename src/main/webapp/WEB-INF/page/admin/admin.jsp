<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Scau工资管理系统 管理员后台</title>
    <link rel="shortcut icon" href="favicon.ico"/>
	<link rel="bookmark" href="favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="../static/easyui/css/default.css" />
    <link rel="stylesheet" type="text/css" href="../static/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../static/easyui/themes/icon.css" />
    <script type="text/javascript" src="../static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../static/easyui/js/outlook2.js"> </script>
    <script type="text/javascript"> <!-- ExamServlet?method=toExamListView -->
	 var _menus = {"menus":[
						{"menuid":"1","icon":"","menuname":"基本信息管理",
							"menus":[
									{"menuid":"11","menuname":"员工基本信息","icon":"icon-exam","url":"examList"}
								]
						},
						{"menuid":"2","icon":"","menuname":"工资详情管理",
							"menus":[
									{"menuid":"21","menuname":"员工工资信息","icon":"icon-user-student","url":"/WageInfo/showWageInfo"},
								]
						},
						{"menuid":"3","icon":"","menuname":"考勤管理",
							"menus":[
									{"menuid":"31","menuname":"考勤列表","icon":"icon-user-teacher","url":"TeacherServlet?method=toTeacherListView"},
								]
						},
						{"menuid":"4","icon":"","menuname":"基础信息管理",
							"menus":[
									{"menuid":"41","menuname":"部门列表","icon":"icon-world","url":"GradeServlet?method=toGradeListView"},
								]
						},
						{"menuid":"5","icon":"","menuname":"系统管理",
							"menus":[
							        {"menuid":"51","menuname":"系统设置","icon":"icon-set","url":"SystemServlet?method=toAdminPersonalView"},
								]
						}
				]};


    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
	<noscript>
		<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
		    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		    <a>123fd456</a>
		</div>
	</noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head"><span style="color:red; font-weight:bold;">${user.name}&nbsp;</span>您好&nbsp;&nbsp;&nbsp;<a href="SystemServlet?method=LoginOut" id="loginOut">安全退出</a></span>
        <span style="padding-left:10px; font-size: 16px; ">SCAU工资管理系统</span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">Copyright &copy; SCAU</div>
    </div>
    <div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
	<div id="nav" class="easyui-accordion" fit="true" border="false">
		<!--  导航内容 -->
	</div>
	
    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<jsp:include page="welcome.jsp" />
		</div>
    </div>
	
	<iframe width=0 height=0 src="refresh.jsp"></iframe>
	
</body>
</html>