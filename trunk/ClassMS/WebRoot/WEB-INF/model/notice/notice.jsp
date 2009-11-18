<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@	taglib uri="/struts-tags" prefix="s" %>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>班务系统</title>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>

	</head>
	<body>
		<h2 class="caption"><div class="float_right"><a class="btn btn_add" href="addLink">添加</a></div>
			公告管理
		</h2>
		<c:choose>
			<c:when test="${pageBean.list==null}">
					还没有公告呢！
			</c:when>
			<c:otherwise>
				<form method="post" action="batch">
				<table class="table">
				<tr><th><a rel="checkall">全选</a></th><th>标题</th><th>发布人</th><th>内容</th><th>时间</th><th>编辑</th><th>删除</th></tr>
						<s:iterator value="pageBean.list" var="notice">  
						<tr>
							<td><input type="checkbox" name="nids" value="${notice.nid}"/></td>
							<td>
								<a href="detail?id=${notice.nid}">${notice.title}</a>
							</td>
							<td>
								${notice.author.realName}
							</td>
							<td>
								${fn:substring(notice.content,0,30)}...
							</td>
							<td>
								<fmt:formatDate value="${notice.time}" pattern="yyyy-MM-dd HH:mm"/>
							</td>
							<td>
								<a href="modify?id=${notice.nid }">编辑</a>
							</td>
							<td>
								<a href="del?id=${notice.nid }">删除</a>
							</td>
						</tr>
					</s:iterator>
				</table>
					<select name="cmd">
						<option value="0" selected="selected">批量操作，请选择</option>
						<option value="1">删除</option>
					</select>
					<input type="submit" value="确定" />
					
					 <s:if test="%{pageBean.currentPage == 1}">  
					     第一页 上一页  
					 </s:if>  
					 <s:else>  
					     <a href="<%=path %>/notice/list?page=1">第一页</a>  
					     <a href="<%=path %>/notice/list?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>  
					 </s:else>  
					 <s:if test="%{pageBean.currentPage != pageBean.totalPage}">  
					     <a href="<%=path %>/notice/list?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>  
					     <a href="<%=path %>/notice/list?page=<s:property value="pageBean.totalPage"/>">最后一页</a>  
					 </s:if>  
					 <s:else>  
					     下一页 最后一页  
					 </s:else>  
					 共<s:property value="pageBean.allRow"/> 条记录  
					 共<s:property value="pageBean.totalPage"/> 页  
					 当前第<s:property value="pageBean.currentPage"/>页 
				</form>
			</c:otherwise>
		</c:choose>
	</body>
</html>