<%@page import="com.hrmsNaaptol.beans.RollBean"%>
<%@page import="com.hrmsNaaptol.beans.DepartmentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrmsNaaptol.dao.CommonDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>hrmsNaaptol</title>
<%String contextPath = request.getContextPath(); %>
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
	<div class="reg">
		<form id="reg" method="post" action="<%=request.getContextPath()%>/ServletController" onsubmit="return validate.checkRegister()">
			<h3 class="regEmployee">Leave Added Successfully </h3>
			<h1 class="regEmployee">Apply Leave</h1>
			<label>Employee Id:</label><br>
			<input type="text" name="employeeId" id="employeeId" placeholder="Employee id" autocomplete="off" maxlength="4" onkeypress="return 

validate.lettersOnly(event)" onblur="validate.checker(this.id,'lblEmployeeId')"  ><br>
			<div id="lblEmployeeId" class="errormsg"></div>
			<label>Enter The Leave Description:</label><br>
			<input type="text" name="description" id="description" placeholder="Description"  autocomplete="off" maxlength="100" onkeypress="return 

validate.lettersOnly(event)" onblur="validate.checker(this.id,'lblDesc')" ><br>
			<div id="lblDesc" class="errormsg"></div>
			<label>From Date:</label> <br>
			<input type="date" name="fromDate" id="fromDate" onblur="validate.checker(this.id,'lblFromDate')"><br>
			<div id="lblFromDate" class="errormsg"></div>
			<label>To Date:</label><br>
			<input type="date" name="toDate" id="toDate" onblur="validate.checker(this.id,'lblToDate')"><br>
			<div id="lblToDate class="errormsg"></div>
			
			<label>Action:</label><br>
			<select id="leaveAction" name="leaveAction" onblur="validate.checker(this.id,'lblAction')">
			<option  value="">Please select Action</option>
			<option value="Request">Request</option>
			</select><br>
			<div id="lblAction" class="errormsg"></div>
			
			<input type="hidden" name="action" value="applyLeave"> 
			<input type="hidden" name="<%=contextPath%>" value="<%=contextPath%>" id="contextPath">
			<input type="submit" id="sub" value="Apply">
			<input type="reset" id="reset" value="Reset">
		</form>
		</div>
		
	</div>
</body> 
</html>