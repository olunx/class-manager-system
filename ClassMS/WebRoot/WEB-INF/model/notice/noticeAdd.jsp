<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
		<link rel="stylesheet" href="<%=path%>/content/kissy/themes/default/editor-min.css" type="text/css" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
        <script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
	</head>
	<body>

		<div>
		 <h2 class="caption">添加新的公告</h2>
			<form id="noticeform" action="save" method="post">
				<input name="id" type="hidden" value="${param.id==null?0:param.id}" />
				<p>
					标题：<s:fielderror><s:param>title</s:param></s:fielderror>
					<input name="title" type="text" class="i_title" value="${title}" />
				</p>
				内容：<s:fielderror><s:param>content</s:param></s:fielderror>
				<textarea name="content" id="content" rows="50" cols="152" style="width: 600px; height: 295px">${content}</textarea>
				
				<p><label><input type="checkbox" name="email" value="1" />是否发送邮件？</label> <label><input type="checkbox" name="fetion" value="1" />是否发送飞信？</label></p>
				<p>
					<input id="submit-btn" type="submit" value="发布公告" />
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