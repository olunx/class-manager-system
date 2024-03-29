<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>添加学生</title>
	</head>
	<body>
		<h2 class="caption">
			添加学生
		</h2>
		<form class="form" action="addStudent" method="post">
			<p>
				<label>
					头像：
				</label>
				<input type="text" name="avatar" />
			</p>
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
					学号：
				</label>
				<input type="text" name="sno" />
				<s:fielderror><s:param>sno</s:param></s:fielderror>
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
					宿舍：
				</label>
				<input type="text" name="dorm" />
				<s:fielderror><s:param>doem</s:param></s:fielderror>
			</p>
			<p>
				<label>
					职务：
				</label>
				<input type="text" name="duty" />
			</p>
			<p>
				<label>
					手机：
				</label>
				<input type="text" name="phoneNo" />
			</p>
			<p>
				<label>
					QQ：
				</label>
				<input type="text" name="qq" />
			</p>
			<p>
				<label>
					邮箱：
				</label>
				<input type="text" name="mail" />
			</p>
			<p class="paddingmin">
				<input type="submit" value="提交" />
				<input type="reset" value="重置" />
			</p>
		</form>
		<h2 class="caption">
			批量注册：
		</h2>
		<form action="fileUpload" method="post" enctype="multipart/form-data">
			<!-- file对应的input必须有name属性,name的值必须和action中的变量对应 -->
			学生数据Excel文件：<input type="file" name="documents" />					
			<input type="submit" value="提交" />
			<s:fielderror><s:param>documents</s:param></s:fielderror>
		</form>
	</body>
</html>