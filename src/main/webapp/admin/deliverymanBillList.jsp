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
		                    <input type="text" autocomplete="off" id="keywords" name="keywords" placeholder="订单编号" class="layui-input " style="height:26px;font-size:12px;"/>
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
		table.reload('billListTable', {
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
			       {type: 'checkbox'}
			      ,{field: 'orderCode', title: '<span style="color:#000;font-weight:bold;">订单编号</span>',align: 'center'}
			      ,{field: 'intoOrOutStatus', title: '<span style="color:#000;font-weight:bold;">订单状态</span>',align: 'center',templet: '#intoOrOutStatusTem'}		  
			      ,{field: 'lineOrderStatus', title: '<span style="color:#000;font-weight:bold;">确认订单</span>',align: 'center', templet: '#checkboxTpl', event: 'setSign'}		  
			      ,{field: '', title: '<span style="color:#000;font-weight:bold;">操作</span>',align: 'center',toolbar: '#toolbar'}
			    ]]
	        	,url:'${pageContext.request.contextPath}/bill/list'
	        	,id: 'billListTable'
	        	,where: {
	        		keywords: $("#keywords").val(),
	        		intoOrOutStatus:1
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
	      		table.reload('billListTable', {
	      		  page: {
	      		    curr: 1 //重新从第 1 页开始
	      		  }
	      		});
	    	});
	      	//多条件查询
	      	$("#btn-search").click(function(){
	      		//表格查询
	      		table.reload('billListTable', {
	      		  page: {
	      		    curr: 1 //重新从第 1 页开始
	      		  }
	      		  ,where: {
	      			//查询传参
	      		   keywords: $("#keywords").val()
	      		  }
	      		});
	      	});
	      	
	      	//toolBar操作列监听
	      	 table.on('tool(tableFilter)', function(obj){
	      		var data = obj.data;
          	//确认订单
	      		if(obj.event === 'setSign'){    
	      			layer.confirm('确认修改订单处理状态？', {
		      	    	  title: "确认消息", //标题
		      	    	  btnAlign: 'c',
		      	    	  btn: ['确认','取消'] //按钮
		      	    	}, function(){	
        	  			   if(data.lineOrderStatus==1){
        	  				 data.lineOrderStatus=0; 
        	  			   }else{    	  			 
        	  				 data.lineOrderStatus=1;   
        	  			   }
        	  			   console.info(data);
		      	    		$.ajax({
		        	  			method: "post",
		        	  			url:"${pageContext.request.contextPath}/bill/save",
		        	  			data:data,
		        	  			success:function(result){    	
		        	  				if(result.data==1){
		        		  				layer.msg('修改成功！', {time: 1000}); //1s后自动关闭
		        		  				//刷新表格内容
		        		  		        table.reload('billListTable', {
		        		  		          page: {
		        		  		            curr: currPageNum //从当前页开始
		        		  		          }
		        		  		        });
		        	  				}else{
		        	  					layer.msg('修改失败！', {time: 1000}); //1s后自动关闭
		        	  					reloadTable(1);
		        	  				}
		        	  	        }
		        			}); 
		      	    	}, function(){
		      	    	  //取消
		      	    	 reloadTable(1);
		      	    	});
	      	    }
	      	
	      		if(obj.event === 'show'){
		      	      //编辑操作
		      	  	  //layer.msg('ID：'+ data.id + ' 的编辑操作');
		      	      layer.open({
		        		  type: 2 //Page层类型
		        		  ,area: ['100%', '100%']
		        		  ,title: ['查看信息', '']
		        		  ,shade: 0.6 //遮罩透明度
		        		  ,fixed: true //位置固定
		        		  ,maxmin: false //开启最大化最小化按钮
		        		  ,anim: 5 //0-6的动画形式，-1不开启
		        		  ,content: 'billInfoShow.jsp?id='+data.id+'&intoOrOutStatus='+data.intoOrOutStatus
		        	   });
		      	      
		      	    }
	      
	      	 });
	      	
	    });
	</script>
	<!-- 操作列  -->
<!-- 		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit" style="font-size:10px;"><i class="layui-icon">&#xe642;</i>编辑</a>
 -->	
<script type="text/html" id="toolbar">

	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="show" style="font-size:10px;"><i class="layui-icon">&#xe615;</i>查看订单详情</a>
</script>
<script type="text/html" id="checkboxTpl">
		{{#  if( d.lineOrderStatus=== 0){ }}
              <input type="checkbox"  value="0"  id="lineOrderStatus" name="lineOrderStatus"  lay-skin="switch" lay-text="是|否">
        {{#  } }} 
        
        {{#  if( d.lineOrderStatus=== 1){ }}
              <input type="checkbox"  value="1"  checked="checked" id="lineOrderStatus"  name="lineOrderStatus" lay-skin="switch" lay-text="是|否">
        {{#  } }} 
	</script>
	<script type="text/html" id="intoOrOutStatusTem">
		{{#  if( d.intoOrOutStatus=== 0){ }} 
        进货
        {{#  } }} 
        
        {{#  if( d.intoOrOutStatus=== 1){ }}
       销售
        {{#  } }} 
	</script>
	
</body>
</html>
