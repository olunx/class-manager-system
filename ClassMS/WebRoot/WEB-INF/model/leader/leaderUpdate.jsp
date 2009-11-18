<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<title>修改领导信息</title>
	</head>
	<body>
		<h2 class="caption">
			修改领导信息
		</h2>
		<form class="form" action="updateLeader" method="post">
			<p>
				<label>
					leaderId：
				</label>
				<input type="text" name="leaderId" value="${leader.leaderId}" readonly="readonly" />
			</p>
			<p>
				<label>
					username：
				</label>
				<input type="text" name="username" value="${leader.username}" />
			</p>
			<p>
				<label>
					password：
				</label>
				<input type="text" name="password" value="${leader.password}" />
			</p>
			<p>
				<label>
					avatar：
				</label>
				<input type="text" name="avatar" value="${leader.avatar}" />
			</p>
			<p>
				<label>
					realName：
				</label>
				<input type="text" name="realName" value="${leader.realName}" />
			</p>
			<p>
				<label>
					remark：
				</label>
				<input type="text" name="remark" value="${leader.remark}" />
			</p>
			<p class="paddingmin">
				<input type="submit" value="提交" />
				<input type="reset" value="重置" />
			</p>
		</form>
	</body>
</html>