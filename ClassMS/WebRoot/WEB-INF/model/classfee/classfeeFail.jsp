<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
%>

<html>
  <head>
    

  </head>
  
  <body>
   		<h1><s:property value="value"/>失败,出错鸟~~~~~^0^~~~~~~~</h1>
   		<a href="<%=path %>/classfee/queryAllclassFee"> 》》》返回班费管理《《《 </a>
  </body>
</html>
