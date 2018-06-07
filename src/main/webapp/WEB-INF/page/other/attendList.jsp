<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="jquery,ui,easy,easyui,web">
    <meta name="description" content="easyui help you build your web page easily!">
    <title>Add search functionality in DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../static/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../static/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../static/easyui/css/demo.css">
    <script type="text/javascript" src="../static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../static/easyui/jquery.easyui.min.js"></script>
    <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
</head>
<body>

     <table id="tt" class="easyui-datagrid" style="width:700px;height:350px"
			url="/attendInfo/statisticalList"
			title="Searching" iconCls="icon-search" toolbar="#tb"
			rownumbers="true" pagination="false">
		<thead>
			<tr>
				<th field="e_id" width="80">员工ID</th>
				<th field="e_name" width="80">姓名</th>
				<th field="ot_days" width="80" align="right">加班天数</th>
				<th field="leave_days" width="80" align="right">请假天数</th>
				<th field="work_days" width="80">工作天数</th>
				<th field="absent_days" width="60" align="center">缺勤天数</th>
				<th field="month" width="60" align="center">月份</th>
				<th field="year" width="60" align="center">年份</th>
			</tr>
		</thead>
	</table>
<!-- 工具栏 -->
	<div id="tb" style="padding:3px">
    		<span>年份:</span>
    		<input id="year" style="line-height:26px;border:1px solid #ccc">
    		<span>员工姓名:</span>
            <input id="e_name" style="line-height:26px;border:1px solid #ccc">
    		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
    		<button id="btn_ot_days">统计信息</button>
    </div>


	<div id="container" style="min-width:50px;height:500px;"></div>


	<script type="text/javascript">

	function doSearch(){
    			$('#tt').datagrid('load',{
    				year: $('#year').val(),
    				e_name: $('#e_name').val()
   			});
    		}
$(document).ready(function() {
   var series = [];

   $("#btn_ot_days").click(function(){
      //alert($(".datagrid-cell-c1-ot_days").html());
      //alert("test!");

                var ot_days_array = [];
                var leave_days_array=[];
                var absent_days_array=[];
                var work_days_array=[];
                for(var i = 0; i < 12; i++){
                  var idStr = "#datagrid-row-r1-2-";
                  var realId = idStr+i;
                  var ot_days = $(realId +" .datagrid-cell-c1-ot_days").text();
                  var leave_days = $(realId +" .datagrid-cell-c1-leave_days").text();
                  var absent_days=$(realId +" .datagrid-cell-c1-absent_days").text();
                  var work_days=$(realId +" .datagrid-cell-c1-work_days").text();
                  if(ot_days != ''){
                      ot_days = parseInt(ot_days);
                      ot_days_array[ot_days_array.length] = ot_days;
                      leave_days=parseInt(leave_days);
                      leave_days_array[leave_days_array.length] = leave_days;
                      absent_days=parseInt(absent_days);
                      absent_days_array[absent_days_array.length]=absent_days;
                      work_days=parseInt(work_days);
                      work_days_array[work_days_array.length]=work_days;
                      //alert("ot_days：" + ot_days);
                  }else{
                      ot_days_array[ot_days_array.length] = 0;
                      leave_days_array[leave_days_array.length] = 0;
                      absent_days_array[leave_days_array.length]=0;
                      work_days_array[work_days_array.length]=0;
                  }
                }

                  var work_obj = {
                      name: '加班天数',
                      data: ot_days_array,
                  };
                  var work_obj2 = {
                      name: '请假天数',
                      data: leave_days_array,
                  };
                  var work_obj3 = {
                      name: '缺勤天数',
                      data: absent_days_array,
                  };
                  var work_obj4 = {
                      name: '工作天数',
                      data: work_days_array,
                  };
        series[series.length] = work_obj;
        series[series.length] = work_obj2;
        series[series.length] = work_obj3;
        series[series.length] = work_obj4;

       // alert(series[series.length-1].name +" "+series[series.length-1].data);


        var title = {
              text: '年考勤统计'
           };
           var subtitle = {
              text: ''
           };
           var xAxis = {
              categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
           };
           var yAxis = {
              title: {
                 text: '天数 (/天)'
              },
              plotLines: [{
                 value: 0,
                 width: 1,
                 color: '#808080'
              }]
           };

           var tooltip = {
              valueSuffix: '/天'
           }

           var legend = {
              layout: 'vertical',
              align: 'right',
              verticalAlign: 'middle',
              borderWidth: 0
           };

           var json = {};

           json.title = title;
           json.subtitle = subtitle;
           json.xAxis = xAxis;
           json.yAxis = yAxis;
           json.tooltip = tooltip;
           json.legend = legend;
           json.series = series;

           $('#container').highcharts(json);
   });

})
</script>
</body>
</html>