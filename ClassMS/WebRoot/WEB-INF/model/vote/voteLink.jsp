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
				<c:choose>
					<c:when test="${!voterexist && !timeout}">
						<input type="hidden" name="vid" value="${vote.vid}">	<br	/>			
						投票主题：${vote.title }<br />
						描述内容：${vote.summary }<br />		
						<c:forEach items="${vote.items}" var="voteItem" varStatus="i">
							<input type="${vote.type==0 ? 'radio' : 'checkbox'}" name="viid" value="${voteItem.viid}" />${i.count}:${voteItem.content } <br />
						</c:forEach>	<br />		
						<s:fielderror><s:param>viid</s:param></s:fielderror>
						<input type="submit" value="投票" >	<br	/>
					</c:when>	
		
					<c:otherwise>						
						<div>
                        <c:if test="${timeout}">投票已经结束了。结束日期：${vote.deadline }</c:if>
							<ul class="ul">
								<li>投票主题：${vote.title }</li>
                                <li><img src="<%=path %>/jfreechart?vid=${vote.vid }"/>	</li>
								<c:forEach items="${vote.items}" var="voteItem" varStatus="i">
										<li>投票选项${i.count}：${voteItem.content } (${voteItem.num }) <br /></li>
								</c:forEach>	
								<li>描述内容：${vote.summary }</li>
								<li>创建人：${vote.author.realName }</li>
								<li>创建日期：${vote.airTime }</li>
								<li>结束日期：${vote.deadline }</li>
								<li>参与人：
									<c:forEach items="${vote.voters}" var="voter" varStatus="i">
											${voter.realName } ;
									</c:forEach>	
								</li>
							</ul>
						</div>
					</c:otherwise>
				</c:choose>

			</form>
		</div>
  </body>
</html>
