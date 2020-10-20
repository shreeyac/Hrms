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
<title>Insert title here</title>
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
	<%@include file="adminHeader.jsp" %>
	<div class="reg">
		<form id="reg" method="post" action="<%=request.getContextPath()%>/ServletController" onsubmit="return validate.checkRegister()">
			<h1 class="regEmployee">Add Employee</h1>
			<label>First Name:</label><br>
			<input type="text" name="fname" id="fname" placeholder="First Name" autocomplete="off" maxlength="20" onkeypress="return 

validate.lettersOnly(event)" onblur="validate.checker(this.id,'lblFirstName')"  ><br>
			<div id="lblFirstName" class="errormsg"></div>
			<label>Last Name:</label><br>
			<input type="text" name="lname" id="lname" placeholder="Last Name"  autocomplete="off" maxlength="20" onkeypress="return 

validate.lettersOnly(event)" onblur="validate.checker(this.id,'lblLastName')" ><br>
			<div id="lblLastName" class="errormsg"></div>
			<label>Date Of Birth:</label> <br>
			<input type="date" name="dateofbirth" id="dateofbirth" onblur="validate.checker(this.id,'lblDob')"><br>
			<div id="lblDob" class="errormsg"></div>
			<label>Date of Joining:</label><br>
			<input type="date" name="dateofjoining" id="dateofjoining" onblur="validate.checker(this.id,'lblDoj')"><br>
			<div id="lblDoj" class="errormsg"></div>
			
			<label>Select Department:</label><br>
			<select id="dept" name="dept" onblur="validate.checker(this.id,'lblDept')">
			<option  value="">Please select a Department</option>
			<%ArrayList dept = new CommonDao().deptList();
			for(int i=0;i<dept.size();i++)
			{DepartmentBean departmentBean = (DepartmentBean)dept.get(i);
			%>
			
			<option value="<%=departmentBean.getPkdepartmentid()%>"><%=departmentBean.getDeptname()%></option>
			<%} %>
			</select><br>
			<div id="lblDept" class="errormsg"></div>
			<label>Select Roll:</label><br>
			<select id="roll" name="roll" onblur="validate.checker(this.id,'lblRoll')">
			<option  value="">Please select a Roll</option>
			<%ArrayList roll = new CommonDao().rollList();
			for(int i=0;i<roll.size();i++)
			{RollBean  rollBean= (RollBean)roll.get(i);
			%>
			<option value="<%=rollBean.getPkrollid()%>"><%=rollBean.getRollname()%></option>
			<%} %>
			</select><br>
			<div id="lblRoll" class="errormsg"></div>
			<label>Mobile No:</label><br>
			<input type="text" name="mobileno" id="mobileno" placeholder="Mobile No" autocomplete="off" maxlength="10"   oninput="this.value = 

this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" onblur="validate.checker(this.id,'lblMobileNo')"><br>
			<div id="lblMobileNo" class="errormsg"></div>
			<label>Password:</label><br>
			<input type="password" name="pass" id="pass" placeholder="Password" autocomplete="off" maxlength="20" onblur="validate.checker

(this.id,'lblPass')"><br>
			<div id="lblPass" class="errormsg"></div>
			<label>Confirm Password:</label><br>
			<input type="password" name="confirmpass" id="confirmpass"  autocomplete="off" placeholder="Confirm Password" maxlength="20" 

onblur="validate.checker(this.id,'lblConfirmPass')"><br>
			<div id="lblConfirmPass" class="errormsg"></div>
		    <label>Select State:</label><br>
			<select id="state" name="state" onblur="validate.checker(this.id,'lblState')">
			<option value="">Please select a state</option>
			<option value="Maharashtra">Maharashtra</option>
			</select>
			<div id="lblState" class="errormsg"></div>
			<label>Select City:</label><br>
			<select id="city" name ="city" onblur="validate.checker(this.id,'lblCity')">
			<option  value="">Please select a City</option>
			<option value="Mumbai">Mumbai</option>
			<option value="Thane">Thane</option>
			<option value="Pune">Pune</option>
			<option value="Nagpur">Nagpur</option>
			<option value="Satara">Satara</option>
			<option>Sangli</option>
			</select><br>
			<div id="lblCity" class="errormsg"></div>
			<label>Address:</label><br>
			<textarea id="address" name="address" onblur="validate.checker(this.id,'lblAddress')"></textarea><br>
			<div id="lblAddress" class="errormsg"></div>
			<label>Picode:</label><br>
			<input type="text" name="pincode" id="pincode" placeholder="Pincode" autocomplete="off" maxlength="6" onblur="validate.checker

(this.id,'lblPincode')"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1')"><br>
			<div id="lblPincode" class="errormsg"></div>
			<input type="hidden" name="action" value="registerSubmit"> 
			<input type="hidden" name="<%=contextPath%>" value="<%=contextPath%>" id="contextPath">
			<input type="submit" id="sub" value="ADD">
			<input type="reset" id="reset" value="Reset">
		</form>
		</div>
		
	</div>
</body> 
</html>