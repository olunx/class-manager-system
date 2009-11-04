<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
%>

<html>
  <head>
    

  </head>
  
  <body>
   		<h1>投票管理</h1>
   		<c:choose> 
			<c:when test="${param.value eq 'add'}"> 
				新建投票成功
				显示投票ID：${req.vid}记录<br />				
					投票主题：${req.title }<br />
					描述内容：${req.summary }<br />
					投票结束时间：${req.deadline }<br />					
					<c:forEach items="${req.items}" var="voteItem" >
						${voteItem.content }
					</c:forEach>
					<br />				
			</c:when> 
			<c:when test="${param.value eq 'queryAll'}"> 
				显示全部投票记录<br>
				<c:forEach items="${req}" var="vote">
					投票ID：${vote.vid}，投票主题：${vote.title }，描述内容：${vote.summary }，投票结束时间：${vote.deadline }
					<c:forEach items="${vote.items}" var="voteItem" >
						${voteItem.content }
					</c:forEach>
					<br />
				</c:forEach>
			</c:when> 
			<c:when test="${param.value eq 'query'}"> 
				显示投票ID：${req.vid}记录<br />				
					投票主题：${req.title }<br />
					描述内容：${req.summary }<br />
					投票结束时间：${req.deadline }<br />					
					<c:forEach items="${req.items}" var="voteItem" >
						${voteItem.content }
					</c:forEach>
					<br />				
			</c:when> 
			<c:when test="${param.value eq 'modify'}"> 
				修改投票成功<br />
				投票ID：${req.vid}记录<br />				
				投票主题：${req.title }<br />
				描述内容：${req.summary }<br />
				投票结束时间：${req.deadline }<br />					
				<c:forEach items="${req.items}" var="voteItem" >
					${voteItem.content }
				</c:forEach>
				<br />				
			</c:when> 
			<c:when test="${param.value eq 'delete'}"> 
				成功删除投票${vid }<br />		
			</c:when> 
			<c:otherwise> 
				未知方法被执行OMG!!!
			</c:otherwise> 
		</c:choose> 
   		<a href="<%=path %>/vote.jsp">返回投票管理</a>
  </body>
</html>
