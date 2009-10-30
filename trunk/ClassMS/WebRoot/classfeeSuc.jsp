<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
%>

<html>
  <head>
    

  </head>
  
  <body>
   		<h1><s:property value="#parameters.value"/>成功</h1>
   		<s:text name="班费记录"/><br/>
   		<s:property value="#request.req.fee"/>
   		<s:iterator id="classFee" value="#request.req" >           
  		   <s:property value="#classFee.fid"/>
  		   <s:property value="#classFee.event"/>
  		   <s:property value="#classFee.fee"/>
  		   <s:property value="#classFee.time"/><br/>
   		</s:iterator>
   		<a href="<%=path %>/classfee.jsp">返回班费管理</a>
  </body>
</html>
