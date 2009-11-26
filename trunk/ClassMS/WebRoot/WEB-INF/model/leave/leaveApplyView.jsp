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
		<h2 class="caption">
			<div class="float_right">
				<c:choose>
					<c:when test="${sessionScope.userType==0}"><a class="btn btn_add" href="addLink?sno=${sno}">添加</a></c:when>
					<c:otherwise><a class="btn" href="list">审核</a> </c:otherwise>
				</c:choose>
				
			</div>
			请假申请情况  - ${requestScope.student.realName }
		</h2>
		
			<c:choose>
				<c:when test="${pageBean.list==null}">
							暂时没有信息
				</c:when>
				<c:otherwise>
					<form name="form1" action="batch?sno=${sno}" method="post">
					<table class="table">
					<tr><th><a rel="checkall">全选</a></th><th>请假原因</th><th>请假人</th><th>申请日期</th><th>状态</th><th>删除</th></tr>
					<s:iterator value="pageBean.list" var="leave">  
						<tr>
							<td>
								<input type="checkbox" name="lids" value="${leave.lid }" />
							</td>
							<td>
								${leave.content}
							</td>
							<td>
								${leave.student.realName }
							</td>
							<td>
								${leave.time }
							</td>
							<td>
								<c:if test="${leave.pass==0}">未审核</c:if>
								<c:if test="${leave.pass==1}">通过</c:if>
								<c:if test="${leave.pass==2}">拒绝</c:if>
							</td>
							<td><a href="del.action?lid=${leave.lid }&sno=${sno}" class="btn_del"></a></td>
						</tr>
					</s:iterator>
					</table>
					
				<c:choose>
						<c:when test="${sessionScope.userType==0}">
							<select name="cmd">
								<option value="0" selected="selected">批量操作，请选择</option>
								<option value="3">删除</option>
							</select>
							<input type="submit" value="确定" />
						</c:when>
						<c:when test="${sessionScope.userType==1}">
							<select name="cmd">
								<option value="0" selected="selected">批量操作，请选择</option>
								<option value="1">设为通过</option>
								<option value="2">设为拒绝</option>
								<option value="3">删除</option>
							</select>
							<input type="submit" value="确定" />
						</c:when>
						<c:when test="${sessionScope.userType==2}">
							<select name="cmd">
								<option value="0" selected="selected">批量操作，请选择</option>
								<option value="1">设为通过</option>
								<option value="2">设为拒绝</option>
								<option value="3">删除</option>
							</select>
							<input type="submit" value="确定" />
						</c:when>
				</c:choose>
				<div id="pagecount">
					<p>
					 	 共<s:property value="pageBean.allRow"/> 条记录  
						 共<s:property value="pageBean.totalPage"/> 页  
						 当前第<s:property value="pageBean.currentPage"/>页 
					 </p>
					 <s:if test="%{pageBean.currentPage == 1}">  
					     <a><span>首页</span></a>
						 <a><span>上一页</span></a>
					 </s:if>  
					 <s:else>  
					     <a href="<%=path %>/leave/listPage?page=1"><span>第一页</span></a>  
					     <a href="<%=path %>/leave/listPage?page=<s:property value="%{pageBean.currentPage-1}"/>&sno=${sessionScope.student.sno}"><span>上一页</span></a>  
					 </s:else>  
					 <s:if test="%{pageBean.currentPage != pageBean.totalPage}">  
					     <a href="<%=path %>/leave/listPage?page=<s:property value="%{pageBean.currentPage+1}"/>&sno=${sessionScope.student.sno}""><span>下一页</span></a>  
					     <a href="<%=path %>/leave/listPage?page=<s:property value="pageBean.totalPage"/>&sno=${sessionScope.student.sno}""><span>最后一页</span></a>  
					 </s:if>  
					 <s:else>  
					     <a><span>下一页</span></a>
						 <a><span>尾页</span></a>
					 </s:else>  
					</div>
					
					</form>
				</c:otherwise>
			</c:choose>
	</body>
</html>