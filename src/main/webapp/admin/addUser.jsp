<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>新增管理员信息</title>
    <link rel="stylesheet" href="../plugins/layui2.x/css/layui.css">
    <link rel="stylesheet" href="../css/style.css">
    <style>
    	.layui-input{height:26px;font-size:12px;width:180px;}
    	.layui-form-select{font-size:12px;width:180px;}
    	dd{line-height:26px;font-size:12px;width:140px;}
    	.layui-elem-field legend{font-size:12px;}
    	.layui-form-radio *{line-height:26px;font-size:12px;}
    </style>
</head>
<body class="body">

<form class="layui-form" action="">  

 <fieldset class="layui-elem-field">
  <legend>基本信息</legend>
  <div class="layui-form-item" style="margin-bottom:3px;">
	        <label class="layui-form-label" style="font-size:12px;line-height:10px;">管理员角色</label>
	         <div class="layui-input-block">
	           <select name="status" id="status" lay-verify="required">
	            <option value="" selected >请选择</option>
	            <option value="1"  >管理员</option>
	            <option value="2">售货员</option>
	            <option value="3">送货员</option> 
	           </select>
	        </div>
        </div>
  		<div class="layui-form-item" style="margin-bottom:3px;">
	        <label class="layui-form-label" style="font-size:12px;line-height:10px;">登录账号</label>
	        <div class="layui-input-block">
	            <input type="text" name="loginId" id="loginId" lay-verify="required" placeholder="必填项" autocomplete="off" 
	            class="layui-input layui-form-danger" style="height:26px;font-size:12px;">
	        </div>
	       </div>
	    <div class="layui-form-item" style="margin-bottom:3px;">
	        
	        <label class="layui-form-label" style="font-size:12px;line-height:10px;">真实姓名</label>
	         <div class="layui-input-block">
	            <input type="text" name="name" id="userName" lay-verify="required" placeholder="必填项" autocomplete="off"
	                   class="layui-input layui-form-danger" style="height:26px;font-size:12px;">
	        </div>
        </div>
         <div class="layui-form-item" style="margin-bottom:3px;text-align:center">
	        
	        <label style="font-size:12px;line-height:10px;color:red">&gt;&gt;默认登录密码是：123456&lt;&lt; </label>   
        </div>
     </fieldset> 
     
   <div class="layui-form-item" style="text-align: center;margin-top:30px;">
        <button class="layui-btn layui-btn-sm layui-btn-normal" lay-submit="" lay-filter="addForm">保存</button>
        &nbsp;&nbsp;
        <button class="layui-btn layui-btn-sm layui-btn-normal" id="close">取消</button>
    </div>
</form>

<script src="../plugins/layui2.x/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use(['form', 'layedit', 'laydate', 'element','upload'], function () {
    var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , element = layui.element
            , upload = layui.upload;
        
    var $ = layui.jquery;

    //日期插件加载
    laydate.render({ 
        elem: '#hiredate' 
     });
    //自定义表单验证
    form.verify({  	
    	 phone:[/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/,'手机号码格式不正确'],
    	 email: [/^$|^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不正确'],
    });
  //重新渲染表单
  function renderForm(){
	  form.render();
  }
  //保存按钮
  form.on('submit(addForm)', function (data) {
	  
	    // formJson.birthday=new Date(formJson.birthday.replace("-","/"));   
        var formJson = data.field;
       // formJson.hiredate=new Date(formJson.hiredate.replace("-","/"));
        //console.info(data);
       // console.info(formJson);
       	$.ajax({
   			method: "post",
   			url:"${pageContext.request.contextPath}/user/save",
   			data: formJson,
   			async:false,
   			success:function(result){
   				var data = result.data;
               	if(data>0){
               		//关闭窗口 并给父页面传值
                       var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                       parent.layer.msg('添加成功！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);             
                       parent.reloadTable(1);
                       parent.layer.close(index);
               	}else{ 
               		 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                       parent.layer.msg('添加失败！', {title:'提示消息',icon: 2, time: 1500}); //1s后自动关闭);                          
                       parent.layer.close(index);
               	}
   			},
   			error: function(){			
   				 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    parent.layer.msg('服务器异常！', {title:'提示消息',icon: 0, time: 1500}); //1s后自动关闭);                          
                    parent.layer.close(index);	
		}  	
           });     
    });
    
    //关闭窗口按钮
    $("#close").click(function(){
    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    	parent.layer.close(index);
    });
        
    });
</script>
</body>
</html>