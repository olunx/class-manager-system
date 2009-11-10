<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>test kissy upload</title>

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
	<div id="demo-page">
	    <h1>KISSY Editor: </h1>
		
	    <form id="demo-form" action="http://lifesinger.org/blog/wp-content/uploads/2009/09/editor-preview.php" method="post">
	        <textarea name="code" id="demo" rows="50" cols="152" style="width: 900px; height: 295px">
			 	<p>欢迎使用 KISSY Editor!</p>
	        </textarea>
	        <p><button id="submit-btn" type="submit">Preview</button></p>
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