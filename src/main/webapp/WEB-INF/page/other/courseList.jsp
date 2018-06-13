<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>列表11fd</title>
	<link rel="stylesheet" type="text/css" href="../static/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../static/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../static/easyui/css/demo.css">
	<script type="text/javascript" src="../static/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../static/easyui/js/validateExtends.js"></script>
	<script type="text/javascript" src="../static/easyui/themes/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	$(function() {
		//datagrid初始化
	    $('#dataList').datagrid({
	        title:'列表',
            iconCls:'icon-more',//图标
            border: true,
            collapsible: false,//是否可折叠的
            fit: true,//自动大小
            method: "get",
            url:"/wagesystem/attendInfo/attendList",
            idField:'id',
            singleSelect: true,//是否单选
            pagination: true,//分页控件
            rownumbers: true,//行号
            sortName:'e_id',
            sortOrder:'asc',
            remoteSort: false,
	        columns: [[
				{field:'chk',checkbox: true,width:50},
 		        {field:'e_id',title:'员工ID',width:100},
 		        {field:'e_name',title:'姓名',width:50},
                {field:'ot_days',title:'加班天数',width:80},
                {field:'absent_days',title:'缺席天数',width:80},
                {field:'leave_days',title:'请假天数',width:80},
                {field:'work_days',title:'工作天数',width:80,sortable: true},
                {field:'year',title:'年份',width:50},
                {field:'month',title:'月份',width:50}

	 		]],
	        toolbar: "#toolbar"
	    });

	   	//设置分页控件
                var p = $('#dataList').datagrid('getPager');
                $(p).pagination({
                    pageSize: 13,//每页显示的记录条数，默认为10
                    pageList: [10,20,30,50,100],//可以设置每页记录条数的列表
                    beforePageText: '0第',//页数文本框前显示的汉字
                    afterPageText: '页    共 {pages} 页',
                    displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
                });

	  	$("#add").click(function(){
        	        var exam = $("#dataList").datagrid("getSelected");
                            	if(exam == null){
                                	$.messager.alert("消息提醒", "请选择考勤进行统计!", "warning");
                                } else{
        	    	                  $("#addDialog").dialog("open");
        	    	                  $("#addForm").form("load", exam);
        	    	            }
        	    });
	  	//设置添加窗口
	    $("#addDialog").dialog({
	    	title: "添加考勤",
	    	width: 450,
	    	height: 400,
	    	iconCls: "icon-add",
	    	modal: true,
	    	collapsible: false,
	    	minimizable: false,
	    	maximizable: false,
	    	draggable: true,
	    	closed: true,
	    	buttons: [
	    		{
					text:'添加',
					plain: true,
					iconCls:'icon-book-add',
					handler:function(){
						var validate = $("#addForm").form("validate");
						if(!validate){
							$.messager.alert("消息提醒","请检查你输入的数据!","warning");
							return;
						} else{

							$.ajax({
								type: "post",
								url: "/wagesystem/attendInfo/addAttend",
								data: $("#addForm").serialize(),
								async: false,
								success: function(msg){
									if(msg == "success"){
										$.messager.alert("消息提醒","添加成功!","info");
										//关闭窗口
										$("#addDialog").dialog("close");
										//清空原表格数据
										$("#add_name").textbox('setValue', "");
										$("#add_time").datebox('setValue', "");
										//刷新
										$('#dataList').datagrid("reload");
									} else{
										$.messager.alert("消息提醒","添加失败!","warning");
										return;
									}
								}
							});
						}
					}
				},
				{
					text:'重置',
					plain: true,
					iconCls:'icon-book-reset',
					handler:function(){
						$("#add_name").textbox('setValue', "");
					}
				},
			]
	    });
	  	
	});
	</script>
</head>
<body>
	<!-- 数据列表 -->
	<table id="dataList" cellspacing="0" cellpadding="0">
	</table> 
	<!-- 工具栏 -->
	<div id="toolbar">
        <div><a id="add" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a></div>
    </div>
	
	<!-- 添加数据窗口 -->
	<div id="addDialog" style="padding: 10px">  
    	<form id="addForm" method="post">
	    	<table cellpadding="8" >
	    		<tr>
	    			<td>姓名:</td>
	    			<td><input id="add_name" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="e_name" data-options="required:true, validType:'repeat_course', missingMessage:'不能为空'" /></td>
	    		</tr>
	    		<tr>
                	 <td>加班天数:</td>
                	 <td><input id="add_ot_days" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="ot_days" data-options="required:true, validType:'repeat_course', missingMessage:'不能为空'" /></td>
                </tr>
                <tr>
                     <td>缺席天数:</td>
                     <td><input id="add_absent_days" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="absent_days" data-options="required:true, validType:'repeat_course', missingMessage:'不能为空'" /></td>
                </tr>
                <tr>
                     <td>请假天数:</td>
                     <td><input id="add_leave_days" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="leave_days" data-options="required:true, validType:'repeat_course', missingMessage:'不能为空'" /></td>
                </tr>
                <tr>
                     <td>工作天数:</td>
                     <td><input id="add_work_days" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="work_days" data-options="required:true, validType:'repeat_course', missingMessage:'不能为空'" /></td>
                </tr>
                <tr>
                     <td>月份:</td>
                     <td><text id="month" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="month" data-options="readonly: true" /></td>
                </tr>
                <tr>
                     <td>年份:</td>
                     <td><text id="year" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="year" data-options="readonly: true" /></td>
                </tr>
	    	</table>
	    </form>
	</div>
</body>
</html>