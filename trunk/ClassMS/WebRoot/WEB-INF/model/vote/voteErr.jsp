<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>投票管理</title>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		

  </head>
  
  <body>
  		<h2 class="caption">
			<div class="float_right">
					<a class="btn" href="<%=path %>/vote/list">返回列表</a>
			</div>
			投票错误
		</h2>
   		<c:choose> 
			<c:when test="${param.error eq 'voterExist'}"> 
				你已经投票了		
			</c:when> 
			<c:when test="${param.error eq 'timeout'}"> 
				该投票已经结束
			</c:when> 
			<c:otherwise> 
							
			</c:otherwise> 
		</c:choose> 
   		<div> <a href="<%=path %>/vote/list">返回列表</a> </div>
  </body>
</html>
