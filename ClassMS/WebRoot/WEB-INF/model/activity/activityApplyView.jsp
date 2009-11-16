<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="s" uri="/struts-tags" %>

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
		<h2 class="caption"><div class="float_right"><a class="btn btn_add" href="#">添加</a></div>
			活动加分申请情况  - ${student.realName }
		</h2>
		
			<c:choose>
				<c:when test="${pageBean.list==null}">
							暂时没有信息
				</c:when>
				<c:otherwise>
					<form name="form1" action="batch?sno=${sno}" method="post">
					<table class="table">
					<tr><th></th><th>类型</th><th>分数</th><th>加分原因</th><th>状态</th><th>删除</th></tr>
					<s:iterator value="pageBean.list" var="activity">  
						<tr>
							<td>
								<input type="checkbox" name="aids" value="${activity.aid }" />
							</td>
							<td>
								${activity.type }
							</td>
							<td>
								${activity.mark }
							</td>
							<td>
								${activity.reason }
							</td>
							<td>
								<c:if test="${activity.pass==0}">未审核</c:if>
								<c:if test="${activity.pass==1}">通过</c:if>
								<c:if test="${activity.pass==2}">拒绝</c:if>
							</td>
							<td><a href="del.action?aid=${activity.aid }&sno=${sno}">删除</a></td>
						</tr>
					</s:iterator>
					</table>
					<select name="cmd">
						<option value="0" selected="selected">批量操作，请选择</option>
						<option value="1">设为通过</option>
						<option value="2">设为拒绝</option>
						<option value="3">删除</option>
					</select>
					<input type="submit" value="确定" />
								   
					 <s:if test="%{pageBean.currentPage == 1}">  
					     第一页 上一页  
					 </s:if>  
					 <s:else>  
					     <a href="<%=path %>/activity/listPage?page=1">第一页</a>  
					     <a href="<%=path %>/activity/listPage?page=<s:property value="%{pageBean.currentPage-1}"/>&sno=${sessionScope.student.sno}">上一页</a>  
					 </s:else>  
					 <s:if test="%{pageBean.currentPage != pageBean.totalPage}">  
					     <a href="<%=path %>/activity/listPage?page=<s:property value="%{pageBean.currentPage+1}"/>&sno=${sessionScope.student.sno}"">下一页</a>  
					     <a href="<%=path %>/activity/listPage?page=<s:property value="pageBean.totalPage"/>&sno=${sessionScope.student.sno}"">最后一页</a>  
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