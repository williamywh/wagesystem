<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>员工信息列表</title>
	<link rel="stylesheet" type="text/css" href="../static/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../static/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../static/easyui/css/demo.css">
	<script type="text/javascript" src="../static/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../static/easyui/themes/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
	function doSearch(){
        			$('#dataList').datagrid('load',{
        				e_name: $('#e_name').val()
       			});
        		}
	$(function() {	
		//datagrid初始化 

	    //设置分页控件 
	    var p = $('#dataList').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,//每页显示的记录条数，默认为10 
	        pageList: [10,20,30,50,100],//可以设置每页记录条数的列表 
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	    }); 
	    //设置工具类按钮
	    $("#add").click(function(){
	    	$("#addDialog").dialog("open");
	    });
	    //成绩统计
	    $("#escore").click(function(){
	    	
	    	var exam = $("#dataList").datagrid("getSelected");
        	if(exam == null){
            	$.messager.alert("消息提醒", "请选择记录进行统计!", "warning");
            } else{
            	var data = {id: exam.id, gradeid: exam.gradeid, clazzid:exam.clazzid,courseid:exam.courseid, type: exam.type};
            	
            	//动态显示该次考试的科目
            	$.ajax({
            		type: "post",
					url: "ScoreServlet?method=ColumnList",
					data: data,
					dataType: "json",
					async: false,
					success: function(result){
						console.log(result);
						var columns = [];  
			            $.each(result, function(i, course){  
			                var column={};  
			                column["field"] = "course"+course.id;    
			                column["title"] = course.name;  
			                column["width"] = 70;  
			                column["resizable"] = false;  
			                column["sortable"] = true;  
			                
			                columns.push(column);//当需要formatter的时候自己添加就可以了,原理就是拼接字符串.  
			            }); 
			            
			            if(exam.type == 1){
			            	columns.push({field:'total',title:'总分',width:70, sortable: true});
			            	
			            	$("#escoreClazzList").combobox("readonly", false);
			            	
			            	$("#escoreClazzList").combobox("clear");
					    	$("#escoreClazzList").combobox("options").queryParams = {gradeid: exam.gradeid};
					    	$("#escoreClazzList").combobox("reload");
			            } else{
			            	$("#escoreClazzList").combobox("readonly", true);
			            }
			            
			            $('#escoreList').datagrid({ 
			    	        columns: [
								columns
			    	        ]
			    	    }); 
					}
            	});
            	setTimeout(function(){
			    	$("#escoreList").datagrid("options").url = "ScoreServlet?method=ScoreList&t="+new Date().getTime();
			    	$("#escoreList").datagrid("options").queryParams = data;
			    	$("#escoreList").datagrid("reload");
			    	
			    	$("#escoreListDialog").dialog("open");
            	}, 100)
	    	}
	    });
	    
	  	//设置添加窗口
	    $("#addDialog").dialog({
	    	title: "添加员工",
	    	width: 650,
	    	height: 460,
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
					iconCls:'icon-add',
					handler:function(){
						var validate = $("#addForm").form("validate");
						if(!validate){
							$.messager.alert("消息提醒","请检查你输入的数据!","warning");
							return;
						} else{
							var gradeid = $("#add_gradeList").combobox("getText");
							$.ajax({
								type: "post",
								// url: "ExamServlet?method=AddExam&t="+new Date().getTime(),
								url: "/jobcategories/addEmployee",
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
										$("#add_remark").textbox('setValue', "");
										//重新加载年级
										$("#add_gradeList").combobox("clear");
										$("#add_gradeList").combobox("reload");
										$("#classn_list").combobox("clear");
                                        $("#classn_list").combobox("reload");
										//重新刷新页面数据
							  			$("#gradeList").combobox('setValue', gradeid);
										$('#dataList').datagrid("options").queryParams = {gradeid: gradeid};
							  			$('#dataList').datagrid("reload");
							  			setTimeout(function(){
											$("#clazzList").combobox('setValue', clazzid);
										}, 100);
										
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
					iconCls:'icon-reload',
					handler:function(){
						$("#add_name").textbox('setValue', "");
						$("#add_time").datebox('setValue', "");
						$("#add_remark").textbox('setValue', "");
						//重新加载
						$("#add_gradeList").combobox("clear");
						$("#add_gradeList").combobox("reload");
						$("#classn_list").combobox("clear");
						$("#classn_list").combobox("reload");
					}
				},
			]
	    });
	  	
	  	//下拉框gradeList
	  	$("#gradeList").combobox({
	  		width: "150",
	  		height: "25",
	  		valueField: "id",
	  		textField: "name",
	  		multiple: false, //可多选
	  		editable: false, //不可编辑
	  		method: "post",
	  		url: "GradeServlet?method=GradeList&t="+new Date().getTime(),
	  		onChange: function(newValue, oldValue){
	  		//加载该年级下的班级
	  			$("#clazzList").combobox("clear");
	  			$("#clazzList").combobox("options").queryParams = {gradeid: newValue};
	  			$("#clazzList").combobox("reload");
	  			
	  			setTimeout(function(){
		  			//加载该年级下的学生
		  			$('#dataList').datagrid("options").queryParams = {gradeid: newValue};
		  			$('#dataList').datagrid("reload");
	  			}, 16);
	  		}
	  	});
	  	//下拉框
	  	$("#clazzList").combobox({
	  		width: "150",
	  		height: "25",
	  		valueField: "id",
	  		textField: "name",
	  		multiple: false, //可多选
	  		editable: false, //不可编辑
	  		method: "post",
	  		url: "ClazzServlet?method=ClazzList&t="+new Date().getTime(),
	  		onChange: function(newValue, oldValue){
	  			//加载班级下的学生
	  			$('#dataList').datagrid("options").queryParams = {clazzid: newValue};
	  			$('#dataList').datagrid("reload");
	  		}
	  	});

        $("#add_gradeList").combobox({
	  		width: "200",
	  		height: "30",
	  		valueField: "j_id", //valueField: "id",
	  		textField: "dept",
	  		multiple: false, //不可多选
	  		editable: false, //不可编辑
	  		method: "post",
	  		// url: "GradeServlet?method=GradeList&t="+new Date().getTime(),
	  		url: "/jobcategories/jobcategoriesDept",
			onLoadSuccess: function(){
				//默认选择第一条数据
				var data = $(this).combobox("getData");
				// $(this).combobox("setValue", data[0].id);
				$(this).combobox("setValue", data[0].dept);
	  		}
	  	});

	  	//add dept
	  	$("#add_gradeList1").combobox({
        	  		width: "200",
        	  		height: "30",
        	  		valueField: "j_id", //valueField: "id",
        	  		textField: "dept",
        	  		multiple: false, //不可多选
        	  		editable: false, //不可编辑
        	  		method: "post",
        	  		url: "/jobcategories/jobcategoriesDept",
        			onLoadSuccess: function(){
        	  		}

            });
	  	
        $("#classn_list").combobox({
	  		width: "200",
	  		height: "30",
	  		valueField: "j_id", //valueField: "id",
	  		textField: "classn",
	  		multiple: false, //不可多选
	  		editable: false, //不可编辑
	  		method: "post",
	  		// url: "GradeServlet?method=GradeList&t="+new Date().getTime(),
	  		url: "/jobcategories/jobcategoriesClassn",
			onLoadSuccess: function(){
				//默认选择第一条数据
				var data = $(this).combobox("getData");
				// $(this).combobox("setValue", data[0].id);
				$(this).combobox("setValue", data[0].classn);
	  		}
	  	});
	  	
	  	//考绩窗口
	    $("#escoreListDialog").dialog({
	    	title: "成绩统计",
	    	width: 850,
	    	height: 550,
	    	iconCls: "icon-chart_bar",
	    	modal: true,
	    	collapsible: false,
	    	minimizable: false,
	    	maximizable: false,
	    	draggable: true,
	    	closed: true,
	    	onClose: function(){
   	        	$("#escoreClazzList").combobox("clear");
   	        }
	    });
	  	//绩列表
	    $('#escoreList').datagrid({ 
   	        border: true, 
   	        collapsible: false,//是否可折叠的 
   	        fit: true,//自动大小 
   	        method: "post",
   	        noheader: true,
   	        singleSelect: true,//是否单选 
   	        rownumbers: true,//行号 
   	        sortOrder:'DESC', 
   	        remoteSort: false,
   	        toolbar: "#escoreToolbar",
   	        frozenColumns: [[  
   				{field:'number',title:'学号',width:120,resizable: false,sortable: false},    
   				{field:'name',title:'姓名',width:120,resizable: false}	,        
   	        ]],
   	    }); 
	  	
	  	$("#redo").click(function(){
	  		var exam = $("#dataList").datagrid("getSelected");
	  		var clazzid = exam.clazzid;
	    	if(exam.type == 1){
	    		clazzid = $("#escoreClazzList").combobox("getValue");
	    	}
        	//var data = {id: exam.id, gradeid: exam.gradeid, clazzid:clazzid,courseid:exam.courseid, type: exam.type};
	    	
        	var url = "ScoreServlet?method=ExportScore&id="+exam.id+"&gradeid="+exam.gradeid+"&clazzid="+clazzid+"&courseid="+exam.courseid+"&type="+exam.type;
	    	
	  		window.open(url, "_blank");
	  	});
			    
	  	//下拉框:选择绩
	  	$("#escoreClazzList").combobox({
	  		width: "150",
	  		height: "25",
	  		valueField: "id",
	  		textField: "name",
	  		multiple: false, //可多选
	  		editable: false, //不可编辑
	  		method: "post",
	  		url: "ClazzServlet?method=ClazzList&t="+new Date().getTime(),
	  		onChange: function(newValue, oldValue){
	  			var exam = $("#dataList").datagrid("getSelected");
            	var data = {id: exam.id, gradeid: exam.gradeid, clazzid:newValue,courseid:exam.courseid, type: exam.type};
	  			
	  			$("#escoreList").datagrid("options").url = "ScoreServlet?method=ScoreList&t="+new Date().getTime();
		    	$("#escoreList").datagrid("options").queryParams = data;
		    	$("#escoreList").datagrid("reload");
	  		}
	  	});
	  	
	    
	});
	</script>
</head>
<body>
	<!-- 数据列表 -->
	<!--<table id="dataList" class="easyui-datagrid" cellspacing="0" cellpadding="0"
        url="employeeInfoStart"
        title="Searching" iconCls="icon-search" toolbar="#toolbar"
        rownumbers="true" pagination="true">-->
        <table id="dataList" class="easyui-datagrid" cellspacing="0" cellpadding="0"
                url="employeeInfoStart"
                fit="true"
                collapsible="false"
                title="Searfching" toolbar="#toolbar"
                rownumbers="true" pagination="true">
        <thead>
			<tr>
				<th field="e_id" width="80">员工ID</th>
				<th field="e_name" width="80">姓名</th>
				<th field="tel" width="100" align="right">电话号码</th>
				<th field="gender" width="80" align="right">性别</th>
				<th field="address" width="150">地址</th>
				<th field="date" width="100" align="center">入职时间</th>
				<th field="password" width="60" align="center">密码</th>
				<th field="note" width="60" align="center">备注</th>
			</tr>
		</thead>
	</table> 
	
	<!-- 工具栏 -->
	<div id="toolbar">
		<div style="float: left;"><a id="add" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a></div>
			<div style="float: left;" class="datagrid-btn-separator"></div>
		<div style="float: left; margin: 0 10px 0 10px">部门：<input id="add_gradeList1" class="easyui-textbox" name="grade" /></div>
		<span>员工姓名:</span>
        <input id="e_name" style="line-height:26px;border:1px solid #ccc">
        <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
	</div>
	
	<!-- 考绩表 -->
	<div id="escoreListDialog">
		<table id="escoreList" cellspacing="0" cellpadding="0"> 
	    
		</table> 
	</div>
	<div id="escoreToolbar">
		<a id="redo" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true">导出</a>
		<span style="margin-left:10px;">部门：<input id="escoreClazzList" class="easyui-textbox" name="clazz" /></span>
	</div>
	
	
	<!-- 添加窗口 -->
	<div id="addDialog" style="padding: 10px">  
    	<form id="addForm" method="post">
	    	<table cellpadding="8" >
	    		<tr>
	    			<td>姓名:</td>
	    			<td><input id="add_name"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="e_name" data-options="required:true, missingMessage:'请输入名称'" /></td>
	    		</tr>
	    		<tr>
                    <td>性别:</td>
                    <td>
                    <!--<input id="add_gender"  class="easyui-textbox" style="width: 200px; height: 30px;" type="text" name="gender" data-options="required:true, missingMessage:'请输入性别'" />-->
                    	<select panelHeight="auto" class="easyui-combobox" name="gender" style="width:200px;">
                    		<option value="男">男</option>
                    		<option value="女">女</option>
                    	</select>
                    </td>
                </tr>
	    		<tr>
	    			<td>入职时间:</td>
	    			<td><input id="add_time" style="width: 200px; height: 30px;" class="easyui-datebox" type="text" name="datetime" data-options="required:true, missingMessage:'请选择日期', editable:false" /></td>
	    		</tr>
	    		<tr>
	    			<td>工种:</td>
	    			<td>
	    				<input id="classn_list" name="classn" style="width: 200px; height: 30px;" class="easyui-textbox" data-options="required:true, missingMessage:'请输入工种'"/>
	    				<!--<input type="hidden" name="type"  value="1"/>-->
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>部门:</td>
	    			<td><input id="add_gradeList" name="dept" style="width: 200px; height: 30px;" class="easyui-textbox" data-options="required:true, missingMessage:'请输入部门'"/></td>
	    		</tr>

	    		<tr>
	    			<td>电话号码:</td>
	    			<td><input id="add_remark" style="width: 200px; height: 30px;" class="easyui-textbox" data-options="multiline: true," name="tel" /></td>
	    		</tr>
	    		<tr>
                    <td>地址:</td>
                    <td><input id="add_address" style="width: 200px; height: 30px;" class="easyui-textbox" data-options="multiline: true," name="address" /></td>
                </tr>
                <tr>
                    <td>头衔:</td>
                    <td><input id="add_title" style="width: 200px; height: 30px;" class="easyui-textbox" data-options="multiline: true," name="title" /></td>
                 </tr>
                <tr>
                    <td>基本工资:</td>
                    <td><input id="add_basewage" style="width: 200px; height: 30px;" class="easyui-textbox" name="base_wage" data-options="required:true, missingMessage:'请输入基本工资'"/></td>
                </tr>
	    	</table>
	    </form>
	</div>
	
</body>
</html>