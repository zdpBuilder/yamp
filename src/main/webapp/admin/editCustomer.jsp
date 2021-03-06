<%@ page language="java" import ="yamp.com.model.Customer" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
//客户管理主键id
int id = Integer.parseInt(request.getParameter("id"));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>修改客户信息</title>
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
    <input type="hidden" name="id" id="id" value="<%=id%>"/>
    <input type="hidden" name="loginPassword" id="loginPassword" />
   <fieldset class="layui-elem-field">
  <legend>基本信息</legend>
  <div class="layui-form-item" style="margin-bottom:3px;">
	        <label class="layui-form-label" style="font-size:12px;line-height:10px;">客户类型</label>
	         <div class="layui-input-block">
	           <select name="status" id="status" lay-verify="required">
	            <option value="" selected >请选择</option>
	            <option value="1"  >个人</option>
	            <option value="2">商家</option>         
	           </select>
	        </div>
        </div>
  		<div class="layui-form-item" style="margin-bottom:3px;">
	        <label class="layui-form-label" style="font-size:12px;line-height:10px;">登录账号</label>
	        <div class="layui-input-block">
	            <input type="text" name="loginId"  id="loginId" disabled  lay-verify="required" placeholder="必填项" autocomplete="off" 
	            class="layui-input layui-form-danger" style="height:26px;font-size:12px;background-color:#F2F2F2;">
	        </div>
	       </div>
	    <div class="layui-form-item" style="margin-bottom:3px;">
	        
	        <label class="layui-form-label" style="font-size:12px;line-height:10px;">真实姓名</label>
	         <div class="layui-input-block">
	            <input type="text" name="name" id="userName" lay-verify="required|username" placeholder="必填项" autocomplete="off"
	                   class="layui-input layui-form-danger" style="height:26px;font-size:12px;">
	        </div>
        </div>
        <div class="layui-form-item" style="margin-bottom:3px;">
	        
	        <label class="layui-form-label" style="font-size:12px;line-height:10px;">电话</label>
	         <div class="layui-input-block">
	            <input type="text" name="phone" id="phone" lay-verify="required|phone" placeholder="必填项" autocomplete="off"
	                   class="layui-input layui-form-danger" style="height:26px;font-size:12px;">
	        </div>
        </div>
        <div class="layui-form-item" style="margin-bottom:3px;">
	        
	        <label class="layui-form-label" style="font-size:12px;line-height:10px;">地址</label>
	         <div class="layui-input-block">
	            <input type="text" name="address" id="address" lay-verify="required" placeholder="必填项" autocomplete="off"
	                   class="layui-input layui-form-danger" style="height:26px;font-size:12px;">
	        </div>
        </div>
         <div class="layui-form-item" style="margin-bottom:3px;text-align:center">
	        
	        <label style="font-size:12px;line-height:10px;color:red">&gt;&gt;默认登录密码是：123456&lt;&lt; </label>   
        </div>
     </fieldset> 
     
    <div class="layui-form-item" style="text-align: center;margin-top:10px;">
        <button class="layui-btn layui-btn-sm layui-btn-normal" lay-submit="" lay-filter="addForm">保存</button>
        &nbsp;&nbsp;
        <button class="layui-btn layui-btn-sm layui-btn-normal" id="close">取消</button>
    </div>
</form>

<script src="../plugins/layui2.x/layui.js" charset="utf-8"></script>
<script type="text/javascript">

    layui.use(['form', 'upload','layedit', 'laydate', 'element'], function () {
    	
        var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate
                , element = layui.element
                , upload = layui.upload;
        var $ = layui.jquery;

      //重新渲染表单
      function renderForm(){
    	  form.render();
      }
      
      //自定义表单验证
      form.verify({  
      	username:[/^.{0,6}$/,'姓名输入过长！'],
      });
      //表单元素赋值
      var userId = <%=id %>;
      $.ajax({
			method: "post",
			data : {"id":userId},
			url:"../adminCustomer/show",
		
			success:function(result){
				result = result.data;
				if(result){
					$("#loginId").val(result.loginId);
					$("#userName").val(result.name);
					$("#phone").val(result.phone);
					$("#address").val(result.address);
					$("#loginPassword").val(result.loginPassword);
					$("#status").val(result.status);
					renderForm();
				}
			}
      });   
        //保存按钮
          form.on('submit(addForm)', function (data) {
            var formJson = data.field;
            	$.ajax({
        			method: "post",
        			url:"../adminCustomer/save",
        			data: formJson,
        			async:false,
        			success:function(result){
        				if(result==null){
                            parent.layer.msg('修改失败！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
                            return;
    					}
        				if(result){
        					var data = result.data;
        					if(data<=0){
                                parent.layer.msg('修改失败！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
	                            return;
        					}
                        		//关闭窗口 并给父页面传值
                                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                                parent.layer.msg('修改成功！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
                                 parent.reloadTable(1);                          	                       
                                parent.layer.close(index); 		
        				}
        			},
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