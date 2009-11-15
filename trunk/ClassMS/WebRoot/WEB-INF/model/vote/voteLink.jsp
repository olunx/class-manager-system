<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	taglib uri="/struts-tags" prefix="s" %>

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
			用户投票
		</h2>
   		<div>
			<form action="<%=path %>/vote/voting" method="post">
				<input type="hidden" name="vid" value="${vote.vid}">	<br	/>			
				投票主题：${vote.title }<br />
				描述内容：${vote.summary }<br />		
				<c:forEach items="${vote.items}" var="voteItem" varStatus="i">
					<input type="${vote.type==0 ? 'radio' : 'checkbox'}" name="viid" value="${voteItem.viid}" />${i.count}:${voteItem.content } 票数：${voteItem.num } <br />
				</c:forEach>	<br />		
				<s:fielderror><s:param>viid</s:param></s:fielderror>
				<c:choose>
					<c:when test="${!voterexist}">
						<input type="submit" value="投票" >	<br	/>
					</c:when>					
					<c:when test="${timeout}">
						<input type="submit" value="投票已经结束" disabled="disabled">	<br	/>
					</c:when>
					<c:otherwise>						
						<input type="submit" value="你已经投票了" disabled="disabled">	<br	/>
					</c:otherwise>
				</c:choose>
				
				投票结束时间：${vote.deadline }	<br />	
			</form>
		</div>
  </body>
</html>
