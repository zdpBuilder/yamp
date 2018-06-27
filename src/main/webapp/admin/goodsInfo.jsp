<%@ page language="java" import="yamp.com.util.SNUtil"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String goodsCode="";
String  id=request.getParameter("id");
if(id==null){
	goodsCode =SNUtil.getSNNumber("GO");	
	}
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
	<input type="hidden" name="imgUrl" id="imgUrlIntoSql"/>
		<input type="hidden" name="braName" id="braName"/>
		<input type="hidden" name="typeTitle" id="typeTitle"/>
		<c:if test="<%=id!=null%>">
			<input type="hidden" name="id" id="id" value="<%=id%>" />
		</c:if>
		<fieldset class="layui-elem-field">
			<legend>基本信息</legend>
			<div class="layui-row">
				<div class="layui-col-xs6">
				<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品编码</label>
						<div class="layui-input-block">
							<input type="text" name="goodsCode" disabled id="goodsCode"  value="<%=goodsCode %>" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品名称</label>
						<div class="layui-input-block">
							<input type="text" name="name" id="name" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">品牌名称</label>
						 <div class="layui-input-block">
					           <select name="braId" id="braId" lay-verify="required" lay-filter="braIdSel">
					            <option value="0" selected >请选择</option>	            
					           </select>
	                     </div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">种类名称</label>
						<div class="layui-input-block">
					           <select name="typeId" id="typeId" lay-verify="required" lay-filter="typIdSel">
					            <option value="0" selected >请选择</option>            
					           </select>
	                     </div>
					</div>
				<!-- 	<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品支进价</label>
						<div class="layui-input-block">
							<input type="text" name="branchBidPrice" id="branchBidPrice" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品箱进价</label>
						<div class="layui-input-block">
							<input type="text" name="boxBidPrice" id="boxBidPrice" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品支单价</label>
						<div class="layui-input-block">
							<input type="text" name="branchPrice" id="branchPrice" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品箱单价</label>
						<div class="layui-input-block">
							<input type="text" name="boxPrice" id="boxPrice" lay-verify="required"
								placeholder="必填项" autocomplete="off"
								class="layui-input layui-form-danger"
								style="height: 26px; font-size: 12px;">
						</div>
					</div>
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品箱个数</label>
						<div class="layui-input-block">
							<input type="text" name="eachBoxNum" id="eachBoxNum" lay-verify="required"
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
					</div>	 -->
					<div class="layui-form-item" style="margin-bottom: 3px;">
						<label class="layui-form-label"
							style="font-size: 12px; line-height: 10px;">商品描述</label>
						<div class="layui-input-block">
								         <textarea  name="note" id="note"   class="layui-input layui-form-danger"  style="height:50px;font-size:12px;" ></textarea>    

						</div>
					</div>
				</div>
				<div class="layui-col-xs6">
					<div class="layui-upload-drag" id="imgUrl">
						<i class="layui-icon"></i>
						<p>点击上传，或将图片拖拽到此处</p>
					</div>
					<div id="preImg"></div>
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

      //重新渲染表单
      function renderForm(){
    	  form.render();
      }
      
      //拖拽上传
      upload.render({
        elem: '#imgUrl'
        ,url: '../goods/uploadPhoto'
        ,done: function(res){
        	if(res){
        		$("#imgUrlIntoSql").val(res.data);
        		pohotoUrl='${pageContext.request.contextPath}/upload_files/goods_photo/'+res.data;
            	$("#preImg").html('<img style=" margin:20px 10px 0 10px;"src="'+pohotoUrl +'" width="240" height="250"/>');	
        	}
        }
      });
      
      function getBraOrTyp(isId,roleStatus){
    	   $.ajax({
   			method: "post",
   			data : {"roleStatus":roleStatus,
   				    "page":0,
   				    "limit":0,},
   			url:"../braagntyp/list",
   			success:function(result){
   				 if(result){
   					 result=result.data;
   					 if(result){
   						for(var i=0;i<result.length;i++){
   							$("#"+isId).append('<option value="'+result[i].id+'">'+result[i].name+'</option>');	
   						} 
   						renderForm();
   					 }
   				 }
   			}
         });   
      }

      getBraOrTyp("braId",1);
      getBraOrTyp("typeId",3);
      
      //下拉框监听事件
       form.on('select(typIdSel)', function(data){
    	   if(data.value==0){
    		   $("#typeTitle").val("");
    		  return;
    	   }
    	   $("#typeTitle").val($("#typeId option:selected").text());
    		});
       form.on('select(braIdSel)', function(data){
    	   if(data.value==0){
    		   $("#braName").val("");
     		  return;
     	   }
    	   $("#braName").val($("#braId option:selected").text());
    		});
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
  					$("#name").val(result.name);
  					$("#typeId").val(result.typeId);
  					$("#typeTitle").val(result.typeTitle);
  					$("#branchPrice").val(result.branchPrice);
  					$("#boxPrice").val(result.boxPrice);
  					$("#branchCount").val(result.branchCount);
  					$("#boxCount").val(result.boxCount);
  					$("#eachBoxNum").val(result.eachBoxNum);
  					$("#branchBidPrice").val(result.branchBidPrice);
  					$("#boxBidPrice").val(result.boxBidPrice);
  					$("#imgUrlIntoSql").val(result.imgUrl);
  					$("#braId").val(result.braId);
  					$("#braName").val(result.braName);
  					$("#note").val(result.note);
  					$("#goodsCode").val(result.goodsCode);
  					pohotoUrl='${pageContext.request.contextPath}/upload_files/goods_photo/'+result.imgUrl;
  	            	$("#preImg").html('<img style=" margin:20px 10px 0 10px;"src="'+pohotoUrl +'" width="240" height="250"/>');	
  					renderForm();
  					
  				}
  			}
        });   
      }
       
        //保存按钮
          form.on('submit(addForm)', function (data) {
            var formJson = data.field;
            	$.ajax({
        			method: "post",
        			url:"../goods/save",
        			data: formJson,
        			async:false,
        			success:function(result){
        				if(result==null){
                            parent.layer.msg('保存失败！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
                            return;
    					}
        				if(result){
        					var data = result.data;
        					if(data<=0){
                                parent.layer.msg('保存失败！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);
	                            return;
        					}
                        		//关闭窗口 并给父页面传值
                                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                                parent.layer.msg('保存成功！', {title:'提示消息',icon: 1, time: 1500}); //1s后自动关闭);                 
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