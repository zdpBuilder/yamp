<%@ page language="java" import="yamp.com.util.SNUtil"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String  id=request.getParameter("id");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>商品信息</title>
<link rel="stylesheet" href="../plugins/layui2.x/css/layui.css">
<link rel="stylesheet" href="../css/style.css">
<style>
.layui-input {
	height: 26px;
	font-size: 12px;
	width: 180px;
}

.layui-form-select {
	font-size: 12px;
	width: 180px;
}

dd {
	line-height: 26px;
	font-size: 12px;
	width: 140px;
}

.layui-elem-field legend {
	font-size: 12px;
}

.layui-form-radio * {
	line-height: 26px;
	font-size: 12px;
}
</style>
</head>
<body class="body">

	<form class="layui-form" action="">
			<input type="hidden" name="id" id="id" value="<%=id%>" />		
		<fieldset class="layui-elem-field">
			<legend>基本信息</legend>	
				<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品编码</label>
						<div class="layui-input-block">
							<input type="text"  name="goodsCode" disabled id="goodsCode"  
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品名称</label>
						<div class="layui-input-block">
							<input type="text" name="name" id="name" disabled 
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>			
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品支数量</label>
						<div class="layui-input-block">
							<input type="text" name="branchCount" id="branchCount" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品箱数量</label>
						<div class="layui-input-block">
							<input type="text" name="boxCount" id="boxCount" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>	
		</fieldset>
		<div class="layui-form-item"
			style="text-align: center; margin-top: 10px;">
			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-submit=""
				lay-filter="addForm">保存</button>
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
       var goods=null;
      //重新渲染表单
      function renderForm(){
    	  form.render();
      }
      
   
      //表单元素赋值
      var goodsId = <%=id %>;
      if(goodsId!=null){
    	  $.ajax({
  			method: "post",
  			data : {"id":goodsId},
  			url:"../goods/show",
  			success:function(result){
  				result = result.data;
  				if(result){
  					goods=result;
  					$("#name").val(result.name); 					
  					$("#goodsCode").val(result.goodsCode);		
  				}
  			}
        });   
      }
       
     
        //保存按钮
          form.on('submit(addForm)', function (data) {
            var formJson = data.field;
            if( goods.branchCount<formJson.branchCount||goods.boxCount<formJson.boxCount){
            parent.layer.msg('木有那么多货了！', {title:'提示消息',icon: 0, time: 1500}); //1s后自动关闭); 
            	return;
            }
            
            goods.branchCount=formJson.branchCount;
            goods.boxCount=formJson.boxCount;
            parent.initGoodsData(goods);
            //关闭窗口 并给父页面传值
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引                   	                       
            parent.layer.close(index);      
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