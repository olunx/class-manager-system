<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
%>

<html>
  <head>
    

  </head>
  
  <body>
   		<h1>~~~投票出错鸟~~~</h1>
   		<c:choose> 
			<c:when test="${param.error eq 'voterExist'}"> 
				你已经投票了		
			</c:when> 
			<c:otherwise> 
				未知方法被执行OMG!!!
				
			</c:otherwise> 
		</c:choose> 
   		<div> <a href="<%=path %>/vote/listvote">返回列表</a> </div>
  </body>
</html>
