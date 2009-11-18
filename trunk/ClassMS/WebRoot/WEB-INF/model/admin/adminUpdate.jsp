<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>修改管理员信息</title>
	</head>
	<body>
		<h2 class="caption">
			修改管理员信息
		</h2>
		<form class="form" action="updateAdmin" method="post">
			<p>
				<label>
					adminId：
				</label>
				<input type="text" name="adminId" value="${admin.adminId}" readonly="readonly" />
			</p>
			<p>
				<label>
					username：
				</label>
				<input type="text" name="username" value="${admin.username}" />
			</p>
			<p>
				<label>
					password：
				</label>
				<input type="text" name="password" value="${admin.password}" />
			</p>
			<p>
				<label>
					avatar：
				</label>
				<input type="text" name="avatar" value="${admin.avatar}" />
			</p>
			<p>
				<label>
					realName：
				</label>
				<input type="text" name="realName" value="${admin.realName}" />
			</p>
			<p>
				<label>
					remark：
				</label>
				<input type="text" name="remark" value="${admin.remark}" />
			</p>
			<p class="paddingmin">
				<input type="submit" value="提交" />
				<input type="reset" value="重置" />
			</p>
		</form>
	</body>
</html>