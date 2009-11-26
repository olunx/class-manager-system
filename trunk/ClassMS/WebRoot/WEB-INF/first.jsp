<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link href="content/images/content.css" rel="stylesheet" type="text/css" />
<link href="content/images/tabs-slideshow.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="content/js/jquery.min.js"></script>
<script type="text/javascript" src="content/js/jquery.tools.min.js"></script>
<script language="javascript" type="text/javascript" src="content/js/common.js"></script>
<script type="text/javascript">
        $(function(){
        $("div.tabs").tabs(".images > div", {effect: 'fade',fadeOutSpeed: "slow",rotate: true}).slideshow();
        });
</script>
</head>
<body>
<h2 class="caption"> 最新公告 </h2>
<c:choose>
  <c:when test="${notices==null}"> 暂时没有公告 </c:when>
  <c:otherwise>
    <div id="index_notice">
      <!-- "previous slide" button -->
      <a class="backward">prev</a>
      <!-- container for the slides -->
      <div class="images">
        <!-- first slide -->
      <c:forEach items="${notices}" var="notice" begin="0" end="2" step="1">
      	<div><h3><span class="author">${notice.author.realName}</span><a href="<%=path%>/notice/detail?id=${notice.nid }">${notice.title }</a></h3> <span class="date"><fmt:formatDate value="${notice.time}" pattern="yyyy-MM-dd HH:mm"/></span><hr class="clear" />${notice.content} </div>
      </c:forEach>

      </div>
      <!-- "next slide" button -->
      <a class="forward">next</a>
      <!-- the tabs -->
      <div class="tabs"> <a href="#"></a> <a href="#"></a> <a href="#"></a> </div>
    </div>
    <div class="clear"></div>
  </c:otherwise>
</c:choose>

逃课排行榜
<ul>
<c:forEach items="${topTruants}" var="topTruant" varStatus="vs" >
	<li>${topTruant.realName }(${fn:length(topTruant.attendances)})</li>
</c:forEach>
</ul>

<c:choose>
  <c:when test="${sessionScope.userType==0}">
    <h2 class="caption">逃课记录</h2>
    <c:forEach items="${sessionScope.student.attendances}" var="a"> <a href="<%=path%>/attendance/getAttendance?aid=${a.aid}">${a.aid}</a><br/>
    </c:forEach>
  </c:when>
</c:choose>
		<h2 class="caption">
			最新投票Top5
		</h2>
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
		
		<h2 class="caption">
			热门投票Top5
		</h2>
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
</body>
</html>