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
		<script language="javascript" type="text/javascript" src="../content/js/lesson.js"></script>
		<title>课程信息</title>
		
	</head>
	<body>

		<h2 class="caption">
			<div class="float_right">
				<a class="btn btn_add" id="create" >添加</a>
			</div>
			<c:choose>
				<c:when test="${pageBean.list==null}">
			没有数据			
		</h2>
		</c:when>
		<c:otherwise>
			课程列表</h2>
			<form action="deleteManyLesson" method="post">
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
							星期几
						</th>
						<th>
							课程名称
						</th>
						<th>
							课程课时
						</th>
						<th>
							逃课人次
						</th>
						<th>
							修改
						</th>
						<th>
							删除
						</th>
					</tr>
					</thead>
					<s:iterator value="pageBean.list" var="lesson">  
						<tr>
							<td>
								<input type="checkbox" name="lessonIds" value="${lesson.lessonId}" />
							</td>
							<td>
								${lesson.lessonId}
							</td>
							<td>
								${lesson.day}
							</td>
							<td>
								${lesson.lessonName}
							</td>
							<td>
								${lesson.lessonPeriod}
							</td>
							<td>
								${lesson.truants }
							</td>
							<td>
								<a rel="update" href="#" value="getLesson?lessonId=${lesson.lessonId}" class="btn_edit"></a>
							</td>
							<td>
								<a href="deleteLesson?lessonId=${lesson.lessonId}" class="btn_del"></a>
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
					     <a href="<%=path %>/lesson/listLesson?page=1"><span>首页</span></a>
					     <a href="<%=path %>/lesson/listLesson?page=<s:property value="%{pageBean.currentPage-1}"/>"><span>上一页</span></a>
					 </s:else>  
					 <s:if test="%{pageBean.currentPage != pageBean.totalPage}">  
					     <a href="<%=path %>/lesson/listLesson?page=<s:property value="%{pageBean.currentPage+1}"/>"><span>下一页</span></a>
					     <a href="<%=path %>/lesson/listLesson?page=<s:property value="pageBean.totalPage"/>"><span>尾页</span></a>
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
	<div id="dialog" title="添加课程">
		<form class="form" action="addLesson" method="post">
			<p>
				<label>
					星期几：
				</label>
				<select size="1" name="day">
					<option selected="selected">
						一
					</option>
					<option>
						二
					</option>
					<option>
						三
					</option>
					<option>
						四
					</option>
					<option>
						五
					</option>
					<option>
						六
					</option>
					<option>
						日
					</option>
				</select>
			</p>
			<p>
				<label>
					课程名称：
				</label>
				<input type="text" name="lessonName" />
			</p>
			<p>
				<label>
					课程课时：
				</label>
				<input type="text" name="lessonPeriod" />
			</p>
			<p class="paddingmin">
				<input type="submit" value="提交" />
				<input type="reset" value="重置" />
			</p>
		</form>
	</div>
	<div id="update-dialog" title="修改课程信息"></div>
	</body>
</html>