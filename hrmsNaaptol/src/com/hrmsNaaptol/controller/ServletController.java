package com.hrmsNaaptol.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrmsNaaptol.beans.EmployeeBean;
import com.hrmsNaaptol.beans.LeaveBean;
import com.hrmsNaaptol.beans.LoginBean;
import com.hrmsNaaptol.beans.StatusBean;
import com.hrmsNaaptol.dao.CommonDao;
import com.hrmsNaaptol.helper.CommonHelper;



public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final LoginBean LoginBean = null;
       
   
    public ServletController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{
		String actionName=request.getParameter("action");
		if(actionName !=null && !"".equals(actionName))
		{
			if("loginSubmit".equals(actionName))
			{
				Long empid = Long.parseLong(request.getParameter("user"));
				String password = request.getParameter("password");
				LoginBean loginBean = new LoginBean();
				loginBean.setEmpid(empid);
				loginBean.setPassword(password);
				
					try {
						StatusBean bean = new CommonHelper().validateLogin(loginBean);
						ArrayList arrayList = new CommonDao().validate(loginBean);
						 HttpSession session=request.getSession(); 
						if(arrayList.size()>0)
						{
							Long pkempid = (Long)arrayList.get(0);
							String lname = (String)arrayList.get(3);
							String fname = (String)arrayList.get(4);
							String name = lname+" "+fname;
							
						if(bean.isIsadmin() )
						{
							session.setAttribute("name", name);
							session.setAttribute("pkempid", pkempid);
							request.getRequestDispatcher("jsp/welcomeAdmin.jsp").forward(request, response);
							request.setAttribute("message", bean.getMessage());
						}
						else if(bean.isStatus())
						{
							session.setAttribute("name", name);
							session.setAttribute("pkempid", pkempid);
							request.getRequestDispatcher("jsp/userPortal.jsp").forward(request, response);
							request.setAttribute("message", bean.getMessage());
						}
						else
						{
							request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
							request.setAttribute("message", bean.getMessage());
						}
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				
			}
			
			else if("registerSubmit".equals(actionName))
			{
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String dateofbirth = request.getParameter("dateofbirth");
				String dateofjoining = request.getParameter("dateofjoining");
				String dept = request.getParameter("dept");
				String roll = request.getParameter("roll");
				String mobileno = request.getParameter("mobileno");
				String pass = request.getParameter("pass");
				String state = request.getParameter("state");
				String city = request.getParameter("city");
				String address = request.getParameter("address");
				String pincode = request.getParameter("pincode");
				
				try
				{
				EmployeeBean employeeBean = new EmployeeBean();
				employeeBean.setFname(fname);
				employeeBean.setLname(lname);
				employeeBean.setDob(dateofbirth);
				employeeBean.setDoj(dateofjoining);
				employeeBean.setDepartment(dept);
				employeeBean.setRoll(roll);
				employeeBean.setMobileno(mobileno);
				employeeBean.setPassword(pass);
				employeeBean.setState(state);
				employeeBean.setCity(city);
				employeeBean.setAddress(address);
				employeeBean.setPincode(pincode);


				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
			}
			
			else if("updateEmployee".equals(actionName))
			{
				String empid = request.getParameter("empid");
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String dateofbirth = request.getParameter("dateofbirth");
				String dateofjoining = request.getParameter("dateofjoining");
				String dept = request.getParameter("dept");
				String roll = request.getParameter("roll");
				String mobileno = request.getParameter("mobileno");
				String pass = request.getParameter("pass");
				String state = request.getParameter("state");
				String city = request.getParameter("city");
				String address = request.getParameter("address");
				String pincode = request.getParameter("pincode");
				
				try
				{
				EmployeeBean employeeBean = new EmployeeBean();
				employeeBean.setPkempid(empid);
				employeeBean.setFname(fname);
				employeeBean.setLname(lname);
				employeeBean.setDob(dateofbirth);
				employeeBean.setDoj(dateofjoining);
				employeeBean.setDepartment(dept);
				employeeBean.setRoll(roll);
				employeeBean.setMobileno(mobileno);
				employeeBean.setPassword(pass);
				employeeBean.setState(state);
				employeeBean.setCity(city);
				employeeBean.setAddress(address);
				employeeBean.setPincode(pincode);
				StatusBean bean = new CommonHelper().updateEmployee(employeeBean);
				if(bean.isStatus())
				{
					request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
			}
			else if("applyLeave".equals(actionName))
			{
				Long empid = Long.parseLong(request.getParameter("employeeId"));
				String description = request.getParameter("description");
				String fromDate = request.getParameter("fromDate");
				String toDate = request.getParameter("toDate");
				String action = request.getParameter("leaveAction");
				
				try
				{
				LeaveBean leaveBean = new LeaveBean();
				leaveBean.setEmpid(empid);
				leaveBean.setDescription(description);
				leaveBean.setFromDate(fromDate);
				leaveBean.setToDate(toDate);
				leaveBean.setAction(action);
				
				StatusBean bean = new CommonHelper().applyLeave(leaveBean);
				if(bean.isStatus())
				{
					request.getRequestDispatcher("jsp/successAddedLeave.jsp").forward(request, response);
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
						
			}
		}
		else
		{
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
			
		}
		
	}

}
