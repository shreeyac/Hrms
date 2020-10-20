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
	<span class="loginTitle"> Welcome To HRMS</span>
		<div class="sidebar">
			<form id="form" action="<%=request.getContextPath()%>/ServletController" method="post">
			<h3 class="loginHeading">Login</h3>
			<div id="error"></div>
			<div>
				<input type="text" id="user" name="user" maxlength="8" class="loginInput" autocomplete="off" placeholder="User Name" onblur="validate.checkEmpty(this.id,'error')" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
			</div>
			<div>
				<input type="password" name="password" id="password" maxlength="20" class="loginInput" placeholder="Password" onblur="validate.checkEmpty(this.id,'error') ; validate.checkPasswordREg(this.id,'error')" autocomplete="off" >
			</div>
 			<input type="hidden" name="action" value="loginSubmit"> 
			<div>
				<input type="submit" value="GO" class="btnLogin" >
				<input type="reset" value="Reset" class="btnLogin" >
			 </div>
			 </form>
		</div>
	</div>
</body> 
</html>