<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		<script type="text/javascript">
	$( function() {
		$(".table").tablesorter( {
			headers : {
				0 : {
					sorter :false
				},
				1 : {
					sorter :false
				},
				8 : {
					sorter :false
				},
				9 : {
					sorter :false
				}
			}
		});
	});
</script>
		<title>学生</title>
	</head>
	<body>
		<h2 class="caption">
			<div class="float_right">
				<a class="btn btn_add" href="addLinkStudent" onclick="return showInBox('addLinkStudent','添加学生',600,400);">添加</a>
			</div>
			学生管理
		</h2>
			<c:choose>
				<c:when test="${pageBean.list==null}">
			没有数据			
		
		
		</c:when>
		<c:otherwise>
			<form action="deleteManyStudent" method="post">
				<table class="table">
					<thead>
						<tr>
							<th>
								<a rel="checkall">全选</a>
							</th>
							<th>
								ID
							</th>
							<th>
								学号
							</th>
							<th>
								姓名
							</th>
							<th>
								宿舍
							</th>
							<th>
								职位
							</th>
							<th>
								手机
							</th>
							<th>
								逃课次数
							</th>
							<th>
								修改
							</th>
							<th>
								删除
							</th>
						</tr>
					</thead>
					<s:iterator value="pageBean.list" var="student">  
						<tr>
							<td>
								<input type="checkbox" name="stuIds" value="${student.stuId}" />
							</td>
							<td>
								${student.stuId}
							</td>
							<td>
								${student.sno}
							</td>
							<td>
								${student.realName}
							</td>
							<td>
								${student.dorm}
							</td>
							<td>
								<c:forEach items="${student.dutys}" var="d">${d.dutyName},</c:forEach>
							</td>
							<td>
								${student.phoneNo}
							</td>
							<td>
								${fn:length(student.attendances)}
							</td>
							<td>
								<a href="getStudent?stuId=${student.stuId}" class="btn_edit" onclick="return showInBox('getStudent?stuId=${student.stuId}','修改学生',600,400);"></a>
							</td>
							<td>
								<a href="deleteStudent?stuId=${student.stuId}" class="btn_del"></a>
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
						 </s:if>  
						 <s:else>  
						     <a href="<%=path %>/student/listStudent?page=1"><span>第一页</span></a>
						     <a href="<%=path %>/student/listStudent?page=<s:property value="%{pageBean.currentPage-1}"/>"><span>上一页</span></a>
						 </s:else>  
						 <s:if test="%{pageBean.currentPage != pageBean.totalPage}">  
						     <a href="<%=path %>/student/listStudent?page=<s:property value="%{pageBean.currentPage+1}"/>"><span>下一页</span></a>
						     <a href="<%=path %>/student/listStudent?page=<s:property value="pageBean.totalPage"/>"><span>最后一页</span></a>
						 </s:if>  
						 <s:else>  
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
