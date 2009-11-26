<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib uri="/struts-tags" prefix="s" %>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/jquery.tablesorter.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../content/images/jquery-ui-1.7.2.custom.css" />
		<script language="javascript" type="text/javascript" src="../content/js/jquery-ui-1.7.2.custom.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/duty.js"></script>
		<title>职务信息</title>
	</head>
	<body>
		<h2 class="caption">
			<div class="float_right">
				<a class="btn btn_add" id="create" href="addLinkDuty"  onclick="return showInBox('addLinkDuty','添加职位',310,200);" >添加</a>
			</div>
			<c:choose>
				<c:when test="${pageBean.list==null}">
			没有数据			
		</h2>
		</c:when>
		<c:otherwise>
			职务列表</h2>
			<form action="deleteManyDuty" method="post">
				<table class="table">
				<thead>
					<tr>
						<th>
						<a rel="checkall" >全选</a>
						</th>
						<th>
							ID
						</th>
						<th>
							担任者
						</th>
						<th>
							职务名称
						</th>
						<th>
							工作介绍
						</th>
						<th>
							修改
						</th>
						<th>
							删除
						</th>
					</tr>
					</thead>
					<s:iterator value="pageBean.list" var="duty">  
						<tr>
							<td>
								<input type="checkbox" name="dutyIds" value="${duty.dutyId}" />
							</td>
							<td>
								${duty.dutyId}
							</td>
							<td>
								<c:forEach items="${duty.students}" var="s">${s.realName},</c:forEach>
							</td>
							<td>
								${duty.dutyName}
							</td>
							<td>
								${duty.job}
							</td>
							<td>
								<a rel="update" href="getDuty?dutyId=${duty.dutyId}"  onclick="return showInBox('getDuty?dutyId=${duty.dutyId}','修改职位',310,250);" class="btn_edit"></a>
							</td>
							<td>
								<a href="deleteDuty?dutyId=${duty.dutyId}" class="btn_del"></a>
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
					     <a href="<%=path %>/duty/listDuty?page=1"><span>首页</span></a>
					     <a href="<%=path %>/duty/listDuty?page=<s:property value="%{pageBean.currentPage-1}"/>"><span>上一页</span></a>
					 </s:else>  
					 <s:if test="%{pageBean.currentPage != pageBean.totalPage}">  
					     <a href="<%=path %>/duty/listDuty?page=<s:property value="%{pageBean.currentPage+1}"/>"><span>下一页</span></a>
					     <a href="<%=path %>/duty/listDuty?page=<s:property value="pageBean.totalPage"/>"><span>尾页</span></a>
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