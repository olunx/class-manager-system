<%@ page pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<html>
  <head>
    

  </head>
  
  <body>
   		<h1>注册</h1>
   		<form action="<%=path %>/reg.action" method="get">
   			用户名：<input type="text" name="username"><br>
   			密  码：<input type="password" name="password"><br>
   			<input type="submit" value="提交">
   		</form>
  </body>
</html>
