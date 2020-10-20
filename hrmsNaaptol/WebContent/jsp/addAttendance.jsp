<%@page import="com.sun.glass.ui.Size"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.hrmsNaaptol.beans.AttendanceBean"%>
    <%@page import="com.hrmsNaaptol.dao.CommonDao"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%String contextPath = request.getContextPath(); %>
<script src="<%=request.getContextPath()%>/js/jquery.js" ></script>
<script src="<%=request.getContextPath()%>/js/script.js" ></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
</head>
<body>
<div class="wrapper">
	<div class="welcome">
	<input type="hidden" name="<%=contextPath%>" value="<%=contextPath%>" id="contextPath">
	<input type="hidden" name="empid" value="<%=session.getAttribute("pkempid") %>" id="empid">
	<h2>Welcome <%=session.getAttribute("name") %></h2>
	<%Long empid = (Long)session.getAttribute("pkempid") ; %>
	<h2>Naaptol HRMS</h2>
	<h2>Date <%=java.time.LocalDate.now()+" "+java.time.LocalTime.now() %></h2>
	</div>

	<%@include file="adminHeader.jsp" %>
	<button onclick="validate.getInOutTime()">In/Out Time</button>
	
	 
	<table border="1" style="margin:auto;font-size:20px; border-color:white;color:white">
	<tr><th>Name</th><th>Date</th><th>ShiftIn</th><th>ShiftOut</th><th>InTime</th><th>OutTime</th><th>LateMark</th><th>TotalHours</th></tr>
	<%ArrayList getDateInOut = new CommonDao().getDateInOutTime(empid);
	if(getDateInOut.size() > 0)
	  {
	for(int i=0;i<getDateInOut.size();i++)
	{
			AttendanceBean attendanceBean = (AttendanceBean)getDateInOut.get(i);
			%>
	<tr><td><%=attendanceBean.getFname()%></td>
		<td><%=attendanceBean.getDate()%></td>
		<td><%=attendanceBean.getShiftin()%></td>
		<td><%=attendanceBean.getShiftout()%></td>
		<td><%=attendanceBean.getIntime()%></td>
		<td><%=attendanceBean.getOuttime()%></td>
		<td><%=attendanceBean.getLatemark()%></td>
		<td><%=attendanceBean.getTotalhours()%></td>
		</tr>
		
	<%}} %>
	</table>
	
	
	
	</div>

</body>
</html>