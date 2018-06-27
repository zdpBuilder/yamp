<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<!DOCTYPE html>
<html> 
<head>
	<meta charset="utf-8">
	<title>冰糕厂后台管理系统</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../plugins/layui2.x/css/layui.css" media="all" />
    <link rel="stylesheet" href="../css/global.css" media="all">
    <link rel="stylesheet" href="../css/style.css" media="all">
	<link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
</head>
  <style>
    	body{overflow-y: scroll;}
    </style>
</head>
<body class="body">

<div class="layui-fluid">  
  <div class="layui-row layui-col-space10">
    
    <div class="layui-col-md12">
	         <div class="layui-field-box">
			    <!-- 操作按钮区域 -->
		        <div class="my-btn-box" style="margin-bottom:-10px;">
		            <div class="fl">	     
		                <a class="layui-btn layui-btn-sm" id="btn-refresh" data-type="refresh"><i class="layui-icon">&#x1002;</i>刷新</a>
		            </div>
		            <div class="fr" >
		                <span class="layui-form-label" style=" margin-top:5px;font-size:12px;vertical-align: top;line-height:10px;">搜索条件：</span>
		                <div class="layui-input-inline">
		                    <input type="text" autocomplete="off" id="keywords" name="keywords" placeholder="名称" class="layui-input " style="height:26px;font-size:12px;"/>
		                </div> 
		                <button class="layui-btn layui-btn-sm" id="btn-search" style="font-size: 10px;"><i class="layui-icon" style="font-size: 14px;">&#xe615;</i>&nbsp;查询</button>
		            </div>
		        </div>
		        <!-- 表格内容区域 -->
			    <div class="layui-col-md12 layui-col-space1">
					<table class="layui-hide" id="layTable" lay-size="sm" lay-filter="tableFilter"></table>
			    </div>
			  </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="../plugins/layui2.x/layui.js"></script>	
	
	<script type="text/javascript">
	var table; //layUI的渲染动态表格
	var currPageNum = 1;//当前页码

	function reloadTable(pageNum){
		//刷新表格内容
		table.reload('goodsListTable', {
		  page: {
		    curr: pageNum //当前页开始
		  } 
		});
	}

	    // layui方法
	    layui.use(['table', 'layer'], function () {
			
	        // 操作对象
	        table = layui.table;
	        var layer = layui.layer;
	        var $ = layui.jquery;
	        
	        // 表格渲染
	        table.render({
			     elem: '#layTable'
			    ,cellMinWidth: 80//自适应列宽
			    ,cols: [[ 
			       //{type:'numbers' ,title: '序号'},
				  {field: 'goodsCode', title: '<span style="color:#000;font-weight:bold;">商品编码</span>',align: 'center',width:160}
			      ,{field: 'name', title: '<span style="color:#000;font-weight:bold;">商品名称</span>',align: 'center'}
			      ,{field: 'branchBidPrice', title: '<span style="color:#000;font-weight:bold;">商品支进价</span>',align: 'center'}
			      ,{field: 'boxBidPrice', title: '<span style="color:#000;font-weight:bold;">商品箱进价</span>',align: 'center'}
			      ,{field: 'branchPrice', title: '<span style="color:#000;font-weight:bold;">商品支单价</span>',align: 'center'}
			      ,{field: 'boxPrice', title: '<span style="color:#000;font-weight:bold;">商品箱单价</span>',align: 'center'}		  
			      ,{field: 'branchCount', title: '<span style="color:#000;font-weight:bold;">商品支数量</span>',align: 'center'}		  
			      ,{field: 'boxCount', title: '<span style="color:#000;font-weight:bold;">商品箱数量</span>',align: 'center'}		  
			      ]]
	        	,url:'${pageContext.request.contextPath}/goods/list'
	        	,id: 'goodsListTable'
	        	,where: {
	        		keywords: $("#keywords").val()
	        	}//查询传参
			    //,skin: 'line' //表格风格
			    ,even: true  //隔行换色
			    ,size: 'sm' //小尺寸的表格
			    ,page: true  //开启分页
			    ,done: function(res, curr, count){
			        //如果是异步请求数据方式，res即为你接口返回的信息。
			        //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
			        //console.log(res);
			        //得到当前页码
			        //console.log(curr);
			        currPageNum = curr;
			        //得到数据总量
			       // console.log(count);
			        
			      }
			  });
	        
	        
	   
	      	
	      	
			//页面刷新
	      	$("#btn-refresh").click(function(){
	      		//清空页面刷新条件
	      		$("#keywords").val("");
	      		//页面刷新
	      		table.reload('goodsListTable', {
	      		  page: {
	      		    curr: 1 //重新从第 1 页开始
	      		  }
	      		});
	    	});
	      	//多条件查询
	      	$("#btn-search").click(function(){
	      		//表格查询
	      		table.reload('goodsListTable', {
	      		  page: {
	      		    curr: 1 //重新从第 1 页开始
	      		  }
	      		  ,where: {
	      			//查询传参
	      		   keywords: $("#keywords").val()
	      		  }
	      		});
	      	});   
	      	
	    });
	</script>
</body>
</html>
