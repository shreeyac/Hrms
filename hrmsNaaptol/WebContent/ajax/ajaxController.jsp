<%@page import="com.hrmsNaaptol.beans.StatusBean"%>
<%@page import="com.hrmsNaaptol.dao.CommonDao"%>
<%@page import="com.hrmsNaaptol.utils.CommonConnection"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.hrmsNaaptol.helper.CommonHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>

<%!public String execute(HttpServletRequest request, HttpServletResponse response)
{
	String actionName=request.getParameter("action");
	if(actionName !=null && !"".equals(actionName))
	{
		if("displayEmployee".equals(actionName))
		{
		try
		{
		ArrayList<?> arrayList = new CommonHelper().employeeList();
		String data = new CommonConnection().toJSON(arrayList);
		return data;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		else if("displayUserInfo".equals(actionName))
		{
			try
			{
				String pkempid = request.getParameter("empid");
			ArrayList<?> arrayList = new CommonHelper().userList(pkempid);
			String data = new CommonConnection().toJSON(arrayList);
			return data;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if("displayUserLeave".equals(actionName))
		{
			try
			{
				String pkempid = request.getParameter("empid");
			ArrayList arrayList = new CommonHelper().userLeave(pkempid);
			String data = new CommonConnection().toJSON(arrayList);
			return data;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if("getInOutTime".equals(actionName))
		{
			try
			{
				String pkempid = request.getParameter("empid");
			int result = new CommonDao().addAttendance(pkempid);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		else if("setDateInOutTime".equals(actionName))
		{
			try
			{
				String pkempid = request.getParameter("empid");
				StatusBean bean = new CommonHelper().setDateInOutTime(pkempid);
				if(bean.isStatus())
				{
					String success = "true";
					return success;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
	
	return null;
}
%>
<%= execute(request, response)%>