<?xml version="1.0" encoding="UTF-8" ?>
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
		<style type="text/css">
		    #demo-page {
		        padding: 50px 20px;
		        width: 1080px;
		        margin: 0 auto;
		        line-height: 18px;
		    }
		    #demo-page h1,
		    #demo-page h2,
		    #demo-page h3 {
		        margin: 1em 0 0.3em;
		    }
		    #demo-page .section ol {
		        margin: 5px 20px;
		    }
		    #demo-page .section ol li {
		        list-style: decimal inside;
		        margin: 5px 0;
		    }
		    #demo-page #submit-btn {
		        padding: 4px 20px;
		        margin: 10px 5px;
		    }
		</style>
	</head>
	<body>
		<div> <a href="<%=path %>/classfee/listclassFee">返回列表</a> </div>
		<div>
			<form action="<%=path %>/classfee/saveclassFee" method="post">
				<input name="fid" type="hidden" value="${classFee.fid }" />
				班费事件：<s:fielderror><s:param>classFee.event</s:param></s:fielderror>
						 <textarea name="classFee.event" id="demo" rows="50" cols="152" style="width: 900px; height: 295px">${classFee.event }</textarea>	<br />
				班费费用：<s:fielderror><s:param>fee</s:param></s:fielderror>
						  <input type="text" name="fee" value="${classFee.fee }"/> <br />
				          <input type="submit" value="提交" />
				          <input type="reset" value="重置"/>
			</form>
		</div>
		
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