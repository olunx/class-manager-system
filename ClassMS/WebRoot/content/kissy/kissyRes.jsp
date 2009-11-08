<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
%>

<html>
  <head>
    

  </head>
  
  <body>
   		<c:choose> 
			<c:when test="${param.status == 0}"> 
				{"status": "0", "imgUrl": "${imgUrl }"}
			</c:when> 
			<c:otherwise> 
				{"status": "1", "error": "上传过程中出错了!!!!!"}				
			</c:otherwise> 
		</c:choose> 
   	
  </body>
</html>


