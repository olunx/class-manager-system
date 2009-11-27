<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>添加管理员</title>
	</head>
	<body>
		<h2 class="caption">
			添加管理员
		</h2>
		<form class="form" action="addAdmin" method="post">
			<p>
				<label>
					用户名：
				</label>
				<input type="text" name="username" />
				<s:fielderror><s:param>username</s:param></s:fielderror>
			</p>
			<p>
				<label>
					密码：
				</label>
				<input type="text" name="password" />
				<s:fielderror><s:param>password</s:param></s:fielderror>
			</p>
			<p>
				<label>
					姓名：
				</label>
				<input type="text" name="realName" />
				<s:fielderror><s:param>realName</s:param></s:fielderror>
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
	</body>
</html>