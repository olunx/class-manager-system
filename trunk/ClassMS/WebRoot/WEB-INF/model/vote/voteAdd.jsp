<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>投票管理</title>
		
		<!-- 1. 页头引入 editor css -->
		<link rel="stylesheet" href="<%=path %>/content/kissy/themes/default/editor-min.css" type="text/css"/>
		<style type="text/css">
		    #demo-page {
		        padding: 50px 20px;
		        width: 1080px;
		        margin: 0 auto;
		        line-height: 18px;
		    }
		    #demo-page h1,
		    #demo-page h2,
		    #demo-page h3 {
		        margin: 1em 0 0.3em;
		    }
		    #demo-page .section ol {
		        margin: 5px 20px;
		    }
		    #demo-page .section ol li {
		        list-style: decimal inside;
		        margin: 5px 0;
		    }
		    #demo-page #submit-btn {
		        padding: 4px 20px;
		        margin: 10px 5px;
		    }
		</style>
	</head>
	<body>
		<div> <a href="<%=path %>/vote/listvote">返回列表</a> </div>
		<div><h1>新建投票</h1> </div>
		<div>
			<form action="<%=path %>/vote/addvote.action" method="post">
			投票主题：<input type="text" name="vote.title" /> <br />
			描述内容：<textarea name="vote.summary" id="demo" rows="50" cols="152" style="width: 900px; height: 295px"></textarea>	<br />	
			投票方式：<input type="radio" name="vote.type" value="0" checked="checked"/>单选
						<input type="radio" name="vote.type" value="radio" />多选 <br />    	
				选项1：<input type="text" name="content" /> <br />
				选项2：<input type="text" name="content" /> <br />
				选项3：<input type="text" name="content" /> <br />
				选项4：<input type="text" name="content" /> <br />
													
			结束时间：<input type="text" name="time"/> <br />
					 <input type="submit" value="发布投票"/>
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