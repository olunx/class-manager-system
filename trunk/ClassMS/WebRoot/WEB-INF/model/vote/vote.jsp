<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>投票管理</title>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../content/images/jquery-ui-1.7.2.custom.css" />
		<script language="javascript" type="text/javascript" src="../content/js/jquery-ui-1.7.2.custom.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
	</head>
	<body>
		<h2 class="caption">
			<div class="float_right">
				<a class="btn btn_add" href="<%=path %>/vote/addLink" >添加</a>
			</div>
			<c:choose>
			
			<c:when test="${pageBean.list==null}">
					没有投票记录</a>
		</h2>
		</c:when>
		<c:otherwise>
			投票管理</h2>
			<form action="<%=path %>/vote/deleteMany" method="post">
				<table class="table">
					<tr>
						<th>
						<a rel="checkall" >全选</a>
						</th>
						<th>投票主题</th>
						<th>投票描述</th>
						<th>创建人</th>
						<th>创建日期</th>
						<th>结束日期</th>
						<th>删除</th>
					</tr>
					<s:iterator value="pageBean.list" var="vote">  
						<tr>						
							<td>
								<input type="checkbox" name="vids" value="${vote.vid }" />
							</td>
							
							<td>
								<a href="<%=path %>/vote/votingLink?vid=${vote.vid}" >${fn:substring(fn:replace(vote.title,"<","&lt;"),0,20)}</a>
							</td>
							<td>
								${fn:substring(fn:replace(vote.summary,"<","&lt;"),0,20)}...
							</td>
							<td>
								${vote.author.realName }
							</td>
							<td>
								<fmt:formatDate value="${vote.airTime}" pattern="yyyy-MM-dd HH:mm"/>
							</td>
							<td>
								<fmt:formatDate value="${vote.deadline}" pattern="yyyy-MM-dd HH:mm"/>
							</td>
							<td>
								<a href="<%=path %>/vote/delete?vid=${vote.vid}" class="btn_del"></a>
							</td>
						</tr>
					</s:iterator>
				</table>
				
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
					     <a href="<%=path %>/vote/listPage?page=1"><span>首页</span></a>
					     <a href="<%=path %>/vote/listPage?page=<s:property value="%{pageBean.currentPage-1}"/>"><span>上一页</span></a>
					 </s:else>  
					 <s:if test="%{pageBean.currentPage != pageBean.totalPage}">  
					     <a href="<%=path %>/vote/listPage?page=<s:property value="%{pageBean.currentPage+1}"/>"><span>下一页</span></a>
					     <a href="<%=path %>/vote/listPage?page=<s:property value="pageBean.totalPage"/>"><span>尾页</span></a>
					 </s:if>  
					 <s:else>
					 <a><span>下一页</span></a>
					 <a><span>尾页</span></a>
					 </s:else>
				 </div>	
				<select name="cmd">
					<option value="0" selected="selected">
						批量操作，请选择
					</option>
					<option value="1">
						删除
					</option>
				</select>
				<input type="submit" value="确定" />
				</form>
			</c:otherwise>
		</c:choose>
			
	</body>
</html>