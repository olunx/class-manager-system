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
			<c:when test="${param.value eq 'add'}"> 
				<h1>新建投票成功</h1> 
				显示投票ID：${vote.vid}记录<br />				
				投票主题：${vote.title }<br />
				描述内容：${vote.summary }<br />
				投票结束时间：${vote.deadline }<br />					
				<c:forEach items="${vote.items}" var="voteItem" >
					${voteItem.content }
				</c:forEach>	<br />				
			</c:when> 
			<c:when test="${param.value eq 'list'}"> 
				显示全部投票记录<br>
				<c:forEach items="${vote}" var="vote">
					投票ID：${vote.vid}，投票主题：${vote.title }，描述内容：${vote.summary }，投票结束时间：${vote.deadline }
					<c:forEach items="${vote.items}" var="voteItem" >
						${voteItem.content }
					</c:forEach>
					<br />
				</c:forEach>
			</c:when> 
			<c:when test="${param.value eq 'voteLink'}"> 
				<form action="<%=path %>/votingvote.action" method="post">
				显示投票ID：${vote.vid}记录<br />				
					投票主题：${vote.title }<br />
					描述内容：${vote.summary }<br />				
					<c:forEach items="${vote.items}" var="voteItem" varStatus="i">
						<input type="radio" name="time" value="${voteItem.viid}" />${i.count}:${voteItem.content } 票数：${voteItem.num } <br />
					</c:forEach>	<br />
					<input type="submit" value="投票">	<br	/>
					<a href="<%=path %>/jfreechart.action?vid=${vote.vid }">查看投票结果</a><br /><br />
					<img src="<%=path %>/jfreechart.action?vid=${vote.vid }"/>	<br />
					投票结束时间：${vote.deadline }	<br />	
				</form>
							
			</c:when> 
			<c:when test="${param.value eq 'modify'}"> 
				修改投票成功<br />
				投票ID：${vote.vid}记录<br />				
				投票主题：${vote.title }<br />
				描述内容：${vote.summary }<br />
				投票结束时间：${vote.deadline }<br />					
				<c:forEach items="${vote.items}" var="voteItem" >
					${voteItem.content }
				</c:forEach>
				<br />				
			</c:when> 
			<c:when test="${param.value eq 'delete'}"> 
				成功删除投票<br />		
			</c:when> 
			<c:when test="${param.value eq 'voting'}"> 
				显示投票ID：${vote.vid}记录<br />				
					投票主题：${vote.title }<br />
					描述内容：${vote.summary }<br />				
					<c:forEach items="${vote.items}" var="voteItem" varStatus="i">
						${i.count}:${voteItem.content } 票数：${voteItem.num } <br />
					</c:forEach>	<br />
					投票结束时间：${vote.deadline }	<br />					
					<img src="<%=path %>/jfreechart.action?vid=${vote.vid }"/>	<br />			
			</c:when> 
			<c:otherwise> 
				未知方法被执行OMG!!!
				
			</c:otherwise> 
		</c:choose> 
   		<div> <a href="<%=path %>/vote/listvote">返回列表</a> </div>
  </body>
</html>