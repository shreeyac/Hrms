<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%String contextPath = request.getContextPath();
String pkempid = request.getParameter("empid");%>
<script src="<%=request.getContextPath()%>/js/jquery.js" ></script>
<script src="<%=request.getContextPath()%>/js/script.js" ></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
</head>
<body>
<div class="wrapper">
	<div class="welcome">
	<h2>Welcome <%=session.getAttribute("name") %></h2>
	<h2>Naaptol HRMS</h2>
	<h2>Date <%=java.time.LocalDate.now()+" "+java.time.LocalTime.now() %></h2>
	</div>
	<%@include file="userHeader.jsp" %>
	 <span style="font-size:20px;padding:10px;color:white">Click the button to view Employee Data</span><button onclick="validate.getUserInfo()">Click Here</button>
	<input type="hidden" name="<%=contextPath%>" value="<%=contextPath%>" id="contextPath">
	<input type="hidden" name="empid" value="<%=pkempid%>" id="empid">
	<div id="showUserData" style="text-align:center ; color:white"></div>
	</div>

</body>
</html>