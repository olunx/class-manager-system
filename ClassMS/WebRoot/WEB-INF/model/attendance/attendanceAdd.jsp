<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="../content/images/content.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="../content/images/jquery-ui-1.7.2.custom.css" />
		<script language="javascript" type="text/javascript" src="../content/js/jquery.min.js"></script>
		<script language="javascript" type="text/javascript" src="../content/js/jquery-ui-1.7.2.custom.min.js"></script>
		<title>添加考勤信息</title>
		<style type="text/css">
		.mod{ margin: 10px 0;}
		.selectable .ui-selecting { background: #FECA40; }
		.selectable .ui-selected { background: #F39814; color: white; }
		.selectable { list-style-type: none; margin: 0; padding: 0; }
		#lessonsel li { margin: 3px; padding: 1px; float: left; width: 20px; height: 20px; font-size: 14px; text-align: center; }
		#studentssel li { margin: 3px; padding: 1px; float: left; width: 60px; height: 30px; font-size: 14px; text-align: center; padding-top:15px; }
		</style>
		<script type="text/javascript">
		$(function() {
			$("#lessonsel").selectable({
				stop: function(){
				var ret = "";
					$(".ui-selected", this).each(function(){
						var index = $("#lessonsel li").index(this);
						ret+=((index + 1)+",");
					});
					$("#lesson").val(ret);
				}
			});
			$("#studentssel").selectable({
				stop: function(){
				var ret = "";
					$(".ui-selected", this).each(function(){
						if ($(this).attr("title")!="")
						ret+=$(this).attr("title")+",";
					});
					$("#students").val(ret);
				}
			});
		});
		</script>
	</head>
	<body>
		<h2 class="caption">
			添加考勤信息
		</h2>
		<form action="addAttendance" method="post">
			<div style="float: left">
				第
				<select size="1" name="week">
					<%
						for (int i = 1; i < 21; i++) {
							out.println("<option>" + i + "</option>");
						}
					%>
				</select>
				周，
			</div>
			<div style="float: left">
				星期
				<select size="1" name="day">
					<option selected="selected">
						一
					</option>
					<option>
						二
					</option>
					<option>
						三
					</option>
					<option>
						四
					</option>
					<option>
						五
					</option>
					<option>
						六
					</option>
					<option>
						日
					</option>
				</select>
			</div>
			<div class="clear"></div>
			<div class="mod">
				第几节课？
				<ol id="lessonsel" class="selectable">
					<li class="ui-state-default">
						1
					</li>
					<li class="ui-state-default">
						2
					</li>
					<li class="ui-state-default">
						3
					</li>
					<li class="ui-state-default">
						4
					</li>
					<li class="ui-state-default">
						5
					</li>
					<li class="ui-state-default">
						6
					</li>
					<li class="ui-state-default">
						7
					</li>
					<li class="ui-state-default">
						8
					</li>
				</ol>
				<input type="hidden" name="lesson" id="lesson"/>
	
			</div>

			<div class="clear"></div>
			<div class="mod">
			逃课学生(请在下面按住Ctrl键选择)：<s:fielderror><s:param>students</s:param></s:fielderror>
			<input type="hidden" name="students" id="students" />
			
			
				<ol id="studentssel"  class="selectable">
				<c:forEach items="${students}" var="stu">
					<li class="ui-state-default" title="${stu.sno }">${stu.realName }<br/></li>
				</c:forEach>
				</ol>
			<input type="hidden" name="clerk" value="${sessionScope.student.sno }" />
			</div>
			<div class="clear"></div>

			<button type="submit">
				提交
			</button>
		</form>
	</body>
</html>