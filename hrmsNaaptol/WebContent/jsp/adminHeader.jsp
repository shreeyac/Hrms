
	 <input type="hidden" name="contextPath" value="<%=request.getContextPath()%>" id="contextPath">
	<input type="hidden" name="empid" value="<%=session.getAttribute("pkempid")%>" id="empid">
<div class="logo"><a href="<%= request.getContextPath() %>/jsp/index.jsp"><img src="<%= request.getContextPath() %>/images/logo.PNG"></a>
	</div>
	<nav>
	<ul>
	<li><a class="active" href="<%= request.getContextPath() %>/jsp/addEmployee.jsp">Add Employee</a></li>
	  <li><a onclick="validate.getEmpInfo()" href="<%= request.getContextPath() %>/jsp/viewEmployeeInfojsp.jsp" >View Information</a> </li>
	  <li><a href="<%= request.getContextPath() %>/jsp/addAttendance.jsp" onclick="validate.setDateShiftinOut()">My Attendance</a></li>
	  <li><a href="logout.jsp">Logout</a></li>
	 
	</ul>
	</nav>
	
	