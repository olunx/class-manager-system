<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	taglib uri="/struts-tags" prefix="s" %>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>投票管理</title>
        <script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/common.js"></script>
		<script language="JavaScript" type="text/javascript" src="../content/js/calendar/WdatePicker.js"></script> 
		<!-- 1. 页头引入 editor css -->
		<link rel="stylesheet" href="<%=path %>/content/kissy/themes/default/editor-min.css" type="text/css"/>
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<h2 class="caption">
			<div class="float_right">
					<a class="btn" href="<%=path %>/vote/list">返回列表</a>
			</div>
			新建投票
		</h2>
			<form class="form" action="<%=path %>/vote/add" method="post">
				<p><label>投票主题：</label>
				<input class="inputlong" type="text" name="vote.title" />	<s:fielderror><s:param>vote.title</s:param></s:fielderror>
				</p>
				<label>描述内容：</label>
				<div class="paddingmin">
				<textarea name="vote.summary" id="demo" rows="50" cols="152" style="width: 600px; height: 150px"></textarea>
				</div>
				<p><label>投票方式：</label>
				<input type="radio" name="vote.type" value="0" checked="checked"/>单选
				<input type="radio" name="vote.type" value="1" />多选
				</p>
				<s:fielderror><s:param>content</s:param></s:fielderror>
				<div id="voteitem">
					<div><label>选项：</label><input class="inputmid" type="text" name="content" /> <a href="#" class="btn_del" onclick="return delVote(this)">删除</a></div>
					<div><label>选项：</label><input class="inputmid" type="text" name="content" /> <a href="#" class="btn_del" onclick="return delVote(this)">删除</a></div>
					<div><label>选项：</label><input class="inputmid" type="text" name="content" /> <a href="#" class="btn_del" onclick="return delVote(this)">删除</a></div>
				</div>
				<p class="paddingmin"><a href="#" class="btn_add" onclick="return addNewVote('voteitem');">再添加三项</a></p>
				<p><label>投票期限：</label>
				<input class="Wdate" type="text" name="time" onfocus="WdatePicker({startDate:'%y-%M-{%d+1} %H:%m:00',minDate:'%y-%M-%d %H:%m:00'})"/> 
				<s:fielderror><s:param>time</s:param></s:fielderror>
				</p>
				<p>
				<input type="submit" value="发布投票"/>
				</p>
			</form>

		</div>
		
		<!-- 2. 页尾引入 editor js and init code -->
		<script type="text/javascript" src="<%=path %>/content/kissy/editor-aio.js"></script>
		<script type="text/javascript">
		    new KISSY.Editor("demo", {
		        base: "<%=path %>/content/",
		        pluginsConfig: {
		            image: {
		                tabs          : ["local", "link"], //"album"],
		                upload: {
		                    actionUrl : "<%=path %>/kissyUpload.action"
		                }
		            },
		            smiley: {
		                tabs          : ["wangwang"]
		            }
		        }
		    });
		</script>
	</body>
</html>