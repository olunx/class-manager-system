<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班费系统</title>
		<script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
 		<h2 class="caption">
			<div class="float_right">
					<a class="btn" href="<%=path %>/classfee/list">返回列表</a>
			</div>
			班费错误
		</h2>
   		<h1><s:property value="value"/>失败,出错鸟~~~~~^0^~~~~~~~</h1>
   		<a href="<%=path %>/classfee/list"> 》》》返回班费管理《《《 </a>
  </body>
</html>
