<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>投票管理</title>
	</head>
	<body>
		<h1>添加新投票</h1>
		<form action="<%=path %>/addvote.action" method="post">
		投票主题：<input type="text" name="vote.title" /> <br />
		描述内容：<textarea rows="3" cols="19" name="vote.summary"></textarea>	<br />		
		投票方式：<input type="radio" name="vote.type" value="0" checked="true"/>单选
					<input type="radio" name="vote.type" value="1" />多选 <br />    	
			选项1：<input type="text" name="content" /> <br />
			选项2：<input type="text" name="content" /> <br />
			选项3：<input type="text" name="content" /> <br />
			选项4：<input type="text" name="content" /> <br />
												
		结束时间：<input type="text" name="time"/> <br />
		图形类型：<select size="1" id="vote.picType" name="vote.picType">
					<option value="0">柱形</option>
					<option value="1">饼图</option>
					<option value="2">其它</option>	
				 </select>	<br />
				 <input type="submit" value="发布投票"/>
		</form>
		<hr />
		<h1>查看全部投票记录</h1>
		<a href="<%=path %>/queryAllvote.action">查看全部投票记录</a>
		<hr />
		<h1>按ID查询投票</h1>
		<form action="<%=path %>/queryvote.action" method="post">
			输入投票ID：<input type="text" name="vid" />
			<input type="submit" value="查询"/>
		</form>
		<hr />
		<h1>修改投票</h1>
		<form action="<%=path %>/modifyvote.action" method="post">
		投票ID：<input type="text" name="vote.vid" /> <br />
		投票主题：<input type="text" name="vote.title" /> <br />
		描述内容：<textarea rows="3" cols="19" name="vote.summary"></textarea>	<br />		
		投票方式：<input type="radio" name="vote.type" value="0" checked="true"/>单选
					<input type="radio" name="vote.type" value="1" />多选 <br />    	
			选项1：<input type="text" name="content" /> <br />
			选项2：<input type="text" name="content" /> <br />
			选项3：<input type="text" name="content" /> <br />
			选项4：<input type="text" name="content" /> <br />
												
		结束时间：<input type="text" name="time"/> <br />
		图形类型：<select size="1" id="vote.picType" name="vote.picType">
					<option value="0">柱形</option>
					<option value="1">饼图</option>
					<option value="2">其它</option>	
				 </select>	<br />
				 <input type="submit" value="修改投票"/>
		</form>
		<hr />
		<h1>按ID删除投票</h1>
		<form action="<%=path %>/deletevote.action" method="post">
			输入你要删除的投票ID：<input type="text" name="vid" />
			<input type="submit" value="删除"/>
		</form>
	</body>
</html>