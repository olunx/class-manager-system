<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<title>班费系统</title>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
	</head>
	<body>
		<h2 class="caption">
			<div class="float_right">
				<a class="btn btn_add" href="<%=path %>/classfee/addLink">添加</a>
			</div>
			<c:choose>
			
			<c:when test="${pageBean.list==null}">
					没有班费记录</a>
			</c:when>
		<c:otherwise>
			班费管理
			</h2>
			<form action="<%=path %>/classfee/deleteMany" method="post">
				<table class="table">
					<tr>
						<th>
						<a rel="checkall" >全选</a>
						</th>
						<th>班费事件</th>
						<th>类别</th>
						<th>费用</th>
						<th>经手人</th>
						<th>创建时间</th>
						<th>修改</th>
						<th>删除</th>
					</tr>
					<s:iterator value="pageBean.list" var="classfee">  
						<tr>						
							<td>
								<input type="checkbox" name="fids" value="${classfee.fid }"/>
							</td>
							<td>
								<a href="<%=path %>/classfee/query?fid=${classfee.fid }">${fn:substring(classfee.event,0,30)}</a>
							</td>
							<td>
								${classfee.fee<0?"支出":"收入" }
							</td>
							<td>
								${classfee.fee } 元
							</td>
							<td>
								${classfee.cmaker.realName }
							</td>
							<td>
								<fmt:formatDate value="${classfee.time}" pattern="yyyy-MM-dd HH:mm"/>
							</td>
							<td>
								<a href="<%=path %>/classfee/modifyLink?fid=${classfee.fid }" class="btn_edit"></a>
							</td>
							<td>
								<a href="<%=path %>/classfee/delete?fid=${classfee.fid }" class="btn_del"></a>
							</td>
						</tr>
						
					 </s:iterator>  
					 <tr><td></td><td></td><td>总计：</td><td>${total }元</td><td></td><td></td><td></td><td></td></tr>
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
					     <a href="<%=path %>/classfee/listPage?page=1"><span>首页</span></a>
					     <a href="<%=path %>/classfee/listPage?page=<s:property value="%{pageBean.currentPage-1}"/>"><span>上一页</span></a>
					 </s:else>  
					 <s:if test="%{pageBean.currentPage != pageBean.totalPage}">  
					     <a href="<%=path %>/classfee/listPage?page=<s:property value="%{pageBean.currentPage+1}"/>"><span>下一页</span></a>
					     <a href="<%=path %>/classfee/listPage?page=<s:property value="pageBean.totalPage"/>"><span>尾页</span></a>
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
<%--<s:iterator value="pageBean.list">  
     <s:property value="fid"/>  
     <s:property value="event"/>  
     <s:property value="fee"/>  
     <a href="<%=path %>/classfee/modifyLink?fid=<s:property value="fid"/>">modify</a>  
     <a href="<%=path %>/classfee/delete?fid=<s:property value="fid"/>" onclick="return askDel()"/>delete</a><br/>  
 </s:iterator>  
 共<s:property value="pageBean.allRow"/> 条记录  
 共<s:property value="pageBean.totalPage"/> 页  
 当前第<s:property value="pageBean.currentPage"/>页<br/>  
   
 <s:if test="%{pageBean.currentPage == 1}">  
     第一页 上一页  
 </s:if>  
 <s:else>  
     <a href="<%=path %>/classfee/listPage?page=1">第一页</a>  
     <a href="<%=path %>/classfee/listPage?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>  
 </s:else>  
 <s:if test="%{pageBean.currentPage != pageBean.totalPage}">  
     <a href="<%=path %>/classfee/listPage?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>  
     <a href="<%=path %>/classfee/listPage?page=<s:property value="pageBean.totalPage"/>">最后一页</a>  
 </s:if>  
 <s:else>  
     下一页 最后一页  
 </s:else>  
	--%></body>
</html>