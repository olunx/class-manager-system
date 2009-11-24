<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
		<link rel="stylesheet" href="<%=path%>/content/kissy/themes/default/editor-min.css" type="text/css" />
	</head>
	<body>

		<div>
			<form class="form" id="postform" action="updatePost.action" method="post">
				<input name="id" type="hidden" value="${param.id==null?0:param.id}" />
				<input name="pid" type="hidden" value="${param.pid==null?0:param.pid}" />
				<label>内容:</label>
				<div class="paddingmin">
				<textarea name="content" id="content" rows="50" cols="152" style="width: 900px; height: 295px">${post.content}</textarea>
				</div>
				<p class="paddingmin">
					<input id="submit-btn" type="submit" value="保存" />
				</p>
			</form>
		</div>
		<script type="text/javascript" src="<%=path%>/content/kissy/editor-aio.js"></script>
		<script type="text/javascript">
	new KISSY.Editor("content", {
		base : "../content/kissy/",
		pluginsConfig : {
			smiley : {
				tabs : [ "wangwang" ]
			}
		}
	});
</script>
	</body>
</html>