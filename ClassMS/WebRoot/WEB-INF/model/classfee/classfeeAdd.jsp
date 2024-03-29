<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班费系统</title>
		<!-- 1. 页头引入 editor css -->
		<link rel="stylesheet" href="<%=path %>/content/kissy/themes/default/editor-min.css" type="text/css"/>
		<script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		

	</head>
	<body>
		<h2 class="caption">
			<div class="float_right">
					<a class="btn" href="<%=path %>/classfee/list">返回列表</a>
			</div>
			新建班费
		</h2>
		
		<form class="form" action="<%=path %>/classfee/save" method="post">
			<input name="fid" type="hidden" value="${classFee.fid }" />
			<p><label>班费费用：</label><s:fielderror><s:param>fee</s:param></s:fielderror>
			<input type="text" name="fee" value="${classFee.fee }"/> （例如：支出5元,填写"-5"；收入10元，填写"10"）</p>
			<label>班费事件：</label><s:fielderror><s:param>classFee.event</s:param></s:fielderror>
				<div class="paddingmin">
					 <textarea name="classFee.event" id="demo" rows="50" cols="152" style="width: 600px; height: 195px">${classFee.event }</textarea>	<br />
				</div>
			         <p class="paddingmin"> <input type="submit" value="提交" />
			          <input type="reset" value="重置"/></p>
		</form>
		
		
		<!-- 2. 页尾引入 editor js and init code -->
		<script type="text/javascript" src="<%=path %>/content/kissy/editor-aio.js"></script>
		<script type="text/javascript">
		    new KISSY.Editor("demo", {
		        base: "<%=path %>/content/",
		        pluginsConfig: {
		            image: {
		                tabs          : ["local", "link"], //"album"],
		                upload: {
		                    actionUrl : "<%=path %>/kissyUpload.action"
		                }
		            },
		            smiley: {
		                tabs          : ["wangwang"]
		            }
		        }
		    });
		</script>
	</body>
</html>