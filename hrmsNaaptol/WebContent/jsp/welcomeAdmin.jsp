<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hrms</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script src="<%=request.getContextPath()%>/js/script.js" ></script>
</head>
<body>
<div class="wrapper">
	<div class="welcome">
	<h2>Welcome <%=session.getAttribute("name") %></h2>
	<h2>Naaptol HRMS</h2>
	<h2>Date <%=java.time.LocalDate.now()+" "+java.time.LocalTime.now() %></h2>
	</div>
	<%@include file="adminHeader.jsp" %>
</div>	
</body>
</html>