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
			投票管理
		</h2>
   		<c:choose> 
			<c:when test="${param.value eq 'add'}"> 
				<h1>新建投票成功</h1> 
				显示投票ID：${vote.vid}<br />	
				投票主题：${vote.title }<br />
				描述内容：${vote.summary }<br />
				投票结束时间：${vote.deadline }<br />					
				<c:forEach items="${vote.items}" var="voteItem" >
					投票选项：${voteItem.content }	<br/>
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
				删除投票成功<br />		
			</c:when> 
			<c:when test="${param.value eq 'deleteMany'}"> 
				删除投票成功<br />		
			</c:when> 
			<c:when test="${param.value eq 'voting'}"> 	
				<div>
						<ul class="ul">
							<li>投票主题：${vote.title }</li>
							<li>描述内容：${vote.summary }</li>
							<li>投票类型：${vote.type==0 ? "单选" : "多选" }</li>
							<c:forEach items="${vote.items}" var="voteItem" varStatus="i">
									<li>投票选项${i.count}：${voteItem.content } 票数：${voteItem.num } <br /></li>
							</c:forEach>	
							<li>创建人：${vote.author.realName }</li>
							<li>创建日期：${vote.airTime }</li>
							<li>结束日期：${vote.deadline }</li>
							<li>参与人：
								<c:forEach items="${vote.voters}" var="voter" varStatus="i">
										${voter.realName } ;
								</c:forEach>	
							</li>
						</ul>
							<img src="<%=path %>/jfreechart?vid=${vote.vid }"/>	<br />		
					</div>	
			</c:when> 
			<c:otherwise> 
				未知方法被执行OMG!!!
				
			</c:otherwise> 
		</c:choose> 
   		<div> <a href="<%=path %>/vote/list">返回列表</a> </div>
  </body>
</html>
