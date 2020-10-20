<div class="logo"><a href="<%= request.getContextPath() %>/jsp/index.jsp"><img src="<%= request.getContextPath() %>/images/logo.PNG"></a>
	</div>
	<nav>
	<ul>
	 <input type="hidden" name="contextPath" value="<%= request.getContextPath() %>" id="contextPath">
	<input type="hidden" name="empid" value="<%=session.getAttribute("pkempid") %>" id="empid">
	  <li><a  href="<%= request.getContextPath() %>/jsp/viewUserInfo.jsp" >View Information</a> </li>
	  <li><a href="<%= request.getContextPath() %>/jsp/addAttendance.jsp" onclick="validate.setDateShiftinOut()">My Attendance</a></li>
	  <li><a href="<%= request.getContextPath() %>/jsp/applyLeave.jsp">Apply for Leave</a></li>
	  <li><a href="<%= request.getContextPath() %>/jsp/viewUserLeave.jsp">View Leave</a></li>
	  <li><a href="logout.jsp">Logout</a></li>
	 
	</ul>
	</nav>
	