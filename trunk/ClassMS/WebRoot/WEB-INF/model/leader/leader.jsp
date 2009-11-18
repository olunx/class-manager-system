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
		<script language="javascript" type="text/javascript" src="../content/js/admin.js"></script>
		<title>领导</title>
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
			领导管理	</h2>
			<form action="deleteManyLeader" method="post">
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
								用户名
							</th>
							<th>
								密码
							</th>
							<th>
								姓名
							</th>
							<th>
								头像
							</th>
							<th>
								备注
							</th>
							<th>
								修改
							</th>
							<th>
								删除
							</th>
						</tr>
					</thead>
					<s:iterator value="pageBean.list" var="leader">  
						<tr>
							<td>
								<input type="checkbox" name="leaderIds" value="${leader.leaderId}" />
							</td>
							<td>
								${leader.leaderId}
							</td>
							<td>
								${leader.username}
							</td>
							<td>
								${leader.password}
							</td>
							<td>
								${leader.realName}
							</td>
							<td>
								${leader.avatar}
							</td>
							<td>
								${leader.remark}
							</td>
							<td>
								<a rel="update" href="#" value="getLeader?leaderId=${leader.leaderId}" class="btn_edit"></a>
							</td>
							<td>
								<a href="deleteLeader?leaderId=${leader.leaderId}" class="btn_del"></a>
							</td>
						</tr>
					</s:iterator>
				</table>
				<select name="cmd">
					<option value="0" selected="selected">
						批量操作，请选择
					</option>
					<option value="1">
						删除
					</option>
				</select>
				<input type="submit" value="确定" />
				
				 <s:if test="%{pageBean.currentPage == 1}">  
					     第一页 上一页  
					 </s:if>  
					 <s:else>  
					     <a href="<%=path %>/leader/listLeader?page=1">第一页</a>  
					     <a href="<%=path %>/leader/listLeader?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>  
					 </s:else>  
					 <s:if test="%{pageBean.currentPage != pageBean.totalPage}">  
					     <a href="<%=path %>/leader/listLeader?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>  
					     <a href="<%=path %>/leader/listLeader?page=<s:property value="pageBean.totalPage"/>">最后一页</a>  
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
		<div id="dialog" title="添加领导">
		<form class="form" action="addLeader" method="post">
			<p>
				<label>
					用户名：
				</label>
				<input type="text" name="username" />
			</p>
			<p>
				<label>
					密码：
				</label>
				<input type="text" name="password" />
			</p>
			<p>
				<label>
					姓名：
				</label>
				<input type="text" name="realName" />
			</p>
			<p>
				<label>
					头像：
				</label>
				<input type="text" name="avatar" />
			</p>
			<p>
				<label>
					备注：
				</label>
				<input type="text" name="remark" />
			</p>
			<p class="paddingmin">
				<input type="submit" value="提交" />
				<input type="reset" value="重置" />
			</p>
		</form>
		</div>
		<div id="update-dialog" title="修改领导信息"></div>
	</body>
</html>