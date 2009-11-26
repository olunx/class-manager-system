<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link href="content/images/content.css" rel="stylesheet" type="text/css" />
<link href="content/images/tabs-no-images.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="content/js/jquery.min.js"></script>
<script type="text/javascript" src="content/js/jquery.tools.min.js"></script>
<script language="javascript" type="text/javascript" src="content/js/common.js"></script>
<script type="text/javascript">
$(function() {
	$("ul.skin2").tabs("div.skin2 > div", {effect: 'fade'});
});
</script>
</head>
<body>
<h2 class="caption"> 欢迎使用！ </h2>
<div id="index_notice" style="width:100%; margin:0 auto;">

<<<<<<< .mine
    <!-- tabs --> 
    <ul class="css-tabs skin2"> 
        <li><a href="#">最新公告</a></li> 
        <li><a href="#">最新投票</a></li> 
        <li><a href="#">个人信息</a></li> 
    </ul> 
 
    <!-- panes --> 
    <div class="css-panes skin2"> 
        <div style="display:block"> 
        </div> 
        
        <div>
        <c:choose>
			<c:when test="${newvotes==null}">
				暂时没有投票
			</c:when>
			<c:otherwise>
				<table class="table">
					<c:forEach items="${newvotes}" var="vote" begin="0" end="4" step="1" >
						<tr>
							<td>
								<a href="<%=path %>/vote/votingLink?vid=${vote.vid}" >${vote.title}</a>
							</td>
							
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${votes==null}">
				暂时没有投票
			</c:when>
			<c:otherwise>
				<table class="table">
					<c:forEach items="${votes}" var="vote" begin="0" end="4" step="1" >
						<tr>
							<td>
								<a href="<%=path %>/vote/votingLink?vid=${vote.vid}" >${vote.title}</a>
							</td>
							
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
        </div> 
        
        <div> 
        </div> 
        
    </div> 
 
</div><!-- end of index_notice -->

</body>
</html>