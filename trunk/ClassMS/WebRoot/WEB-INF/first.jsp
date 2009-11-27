<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
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

    <!-- tabs --> 
    <ul class="css-tabs skin2"> 
        <li><a href="#">最新公告</a></li> 
        <li><a href="#">最新投票</a></li> 
        <li><a href="#">个人信息</a></li> 
    </ul> 
 
    <!-- panes --> 
    <div class="css-panes skin2"> 
    
        <div style="display:block" class="adiv"> 
			<div id="toptruant">
			<h3>逃课风云榜</h3>
			<ul>
			<c:choose>
				<c:when test="${topTruants==null}"><li>暂时没有考勤数据</li> </c:when>
				<c:otherwise>
					<c:forEach items="${topTruants}" var="topTruant" varStatus="vs" >
						<li class="top10_${vs.count }"><span>${fn:length(topTruant.attendances)}</span>${topTruant.realName }</li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
 			</ul>
 			</div>
        	<div id="news">
        	<h3>最新公告</h3>
			<c:choose>
			<c:when test="${notices==null}"> 暂时没有公告 </c:when>
			<c:otherwise>
			<table class="table">
				<c:forEach items="${notices}" var="notice" begin="0" end="2" step="1">
					<tr>
						<td style="padding-left:10px;overflow: hidden;">
						<a style="float:left;" href="<%=path%>/notice/detail?id=${notice.nid }" >标题：${fn:substring(fn:replace(notice.title,"<","&lt;"),0,20)}，内容：${fn:substring(fn:replace(notice.content,"<","&lt;"),0,20)}...</a>
						<a style="float:right;">${notice.author.realName}，<fmt:formatDate value="${notice.time}" pattern="yyyy-MM-dd HH:mm"/></a>
						</td>
					</tr>
				</c:forEach>
			</table>
			</c:otherwise>
			</c:choose>
			</div>
        </div> 
        
        <div class="adiv">
        	<h3>最新投票</h3>
	        <c:choose>
				<c:when test="${newvotes==null}">
					暂时没有投票
				</c:when>
				<c:otherwise>
					<table class="table">
						<c:forEach items="${newvotes}" var="vote" begin="0" end="4" step="1" >
							<tr>
								<td style="padding-left:20px;">
									<a style="float:left;" href="<%=path %>/vote/votingLink?vid=${vote.vid}" >主题：${fn:substring(fn:replace(vote.title,"<","&lt;"),0,20)}，内容：${fn:substring(fn:replace(vote.summary,"<","&lt;"),0,30)}...</a>
									<a style="float:right;">结束时间：${vote.deadline}</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
			<h3>热门投票</h3>
			<c:choose>
				<c:when test="${votes==null}">
					暂时没有投票
				</c:when>
				<c:otherwise>
					<table class="table">
						<c:forEach items="${votes}" var="vote" begin="0" end="4" step="1" >
							<tr>
								<td style="padding-left:20px;">
									<a style="float:left;" href="<%=path %>/vote/votingLink?vid=${vote.vid}" >主题：${fn:substring(fn:replace(vote.title,"<","&lt;"),0,20)}，内容：${fn:substring(fn:replace(vote.summary,"<","&lt;"),0,30)}...</a>
									<a style="float:right;">结束时间：${vote.deadline}</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>

        </div> 
        
        <div class="adiv"> 
        </div> 
        
    </div> 
 
</div><!-- end of index_notice -->

</body>
</html>