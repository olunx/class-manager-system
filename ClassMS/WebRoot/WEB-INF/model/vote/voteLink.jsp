<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
%>

<html>
  <head>
    

  </head>
  
  <body>
   		<div><h1>投票</h1></div>
   		<div>
			<form action="<%=path %>/vote/votingvote" method="post">
			显示投票ID：${vote.vid}记录<br />				
				投票主题：${vote.title }<br />
				描述内容：${vote.summary }<br />		
				<c:forEach items="${vote.items}" var="voteItem" varStatus="i">
							<input type="${vote.type==0 ? 'radio' : 'checkbox'}" name="viid" value="${voteItem.viid}" />${i.count}:${voteItem.content } 票数：${voteItem.num } <br />
						</c:forEach>	<br />		
				<c:choose>
					<c:when test="${!voterexist}">
						<input type="submit" value="投票" >	<br	/>
					</c:when>
					<c:otherwise>						
						<input type="submit" value="你已经投票了" disabled="disabled">	<br	/>
					</c:otherwise>
				</c:choose>
				
				投票结束时间：${vote.deadline }	<br />	
			</form>
		</div>
		<div> <a href="<%=path %>/vote/listvote">返回列表</a> </div>
  </body>
</html>
