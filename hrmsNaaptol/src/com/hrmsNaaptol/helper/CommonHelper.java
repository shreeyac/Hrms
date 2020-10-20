package com.hrmsNaaptol.helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.hrmsNaaptol.beans.EmployeeBean;
import com.hrmsNaaptol.beans.LeaveBean;
import com.hrmsNaaptol.beans.LoginBean;
import com.hrmsNaaptol.beans.StatusBean;
import com.hrmsNaaptol.dao.CommonDao;

import javafx.animation.StrokeTransitionBuilder;

public class CommonHelper 
{
  public StatusBean validateLogin(LoginBean loginBean) throws SQLException 
  {
	  StatusBean statusBean = new StatusBean();
	  ArrayList arrayList = new CommonDao().validate(loginBean);
	  if(arrayList.size() > 0)
	  {
	  Long empid = (Long) arrayList.get(0);
	  String password = (String) arrayList.get(1);
	  String isadmin = (String)arrayList.get(2);
	  
	 
	  if( empid.equals(loginBean.getEmpid()) && password.equals(loginBean.getPassword()) && "1".equalsIgnoreCase(isadmin))
	 {
		  
			statusBean.setMessage("Admin Login"); 
			statusBean.setIsadmin(true);
			statusBean.setStatus(true);
	 }
	  else if(empid.equals(loginBean.getEmpid()) && password.equals(loginBean.getPassword()))
	  {
		  statusBean.setMessage("Admin Login"); 
			statusBean.setStatus(true);
		  
	  }
	  
		  else
		  {
			  statusBean.setMessage("Login unsuccessfull");
			  statusBean.setStatus(false);
		  }
		 
		  
	 }
	  
	  else
	  {
		  statusBean.setMessage("Login unsuccessfull");
		  statusBean.setStatus(false);
	  }
	 
	  
	return statusBean;
	  
  }
  
  public StatusBean registerEmployee(EmployeeBean employeeBean) throws SQLException 
  {
	  
	  StatusBean statusBean = new StatusBean();
	  int status = new CommonDao().registerEmployee(employeeBean);
	  if (status > 0) 
	  {
		   statusBean.setMessage("registerd successfully");
		   statusBean.setStatus(true);
	}
	  
	return statusBean;
	  
  }
  public StatusBean applyLeave(LeaveBean leaveBean) throws SQLException
  { StatusBean statusBean = new StatusBean();
  int status = new CommonDao().applyLeave(leaveBean);
  if (status > 0) 
  {
	   statusBean.setMessage("registerd successfully");
	   statusBean.setStatus(true);
}
  
return statusBean;
  }
  
  public StatusBean updateEmployee(EmployeeBean employeeBean) throws SQLException 
  {
	  
	  StatusBean statusBean = new StatusBean();
	  int status = new CommonDao().updateEmployee(employeeBean);
	  if (status > 0) 
	  {
		   statusBean.setMessage("registerd successfully");
		   statusBean.setStatus(true);
	}
	  
	return statusBean;
	  
  }
  
  public StatusBean setDateInOutTime(String pkempid) throws SQLException 
  {
	  
	  StatusBean statusBean = new StatusBean();
	  int status = new CommonDao().setDateInOutTime(pkempid);
	  if (status > 0) 
	  {
		   statusBean.setMessage("added successfully");
		   statusBean.setStatus(true);
	}
	  
	return statusBean;
	  
  }
  
  
  public ArrayList employeeList() throws SQLException
  {
	  ArrayList<?> arrayList = new CommonDao().employeeDetails();
	  
	  return arrayList;
  }
  public ArrayList userLeave(String pkempid) throws SQLException
  {
	  ArrayList arrayList = new CommonDao().userLeave(pkempid);
	  
	  return arrayList;
  }
  
  public ArrayList userList(String pkempid) throws SQLException
  {
	  ArrayList<?> arrayList = new CommonDao().userDetails(pkempid);
	  
	  return arrayList;
  }


	
}
