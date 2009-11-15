<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
			查看投票
		</h2>
		<div>
			<ul>
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
		<div>
			<a href="<%=path %>/vote/delete?vid=${vote.vid}" class="btn_del">删除</a>
			<a href="<%=path %>/vote/votingLink?vid=${vote.vid}">投票</a>
		</div>
	</body>
</html>