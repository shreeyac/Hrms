package com.hrmsNaaptol.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.hrmsNaaptol.beans.AttendanceBean;
import com.hrmsNaaptol.beans.DepartmentBean;
import com.hrmsNaaptol.beans.EmployeeBean;
import com.hrmsNaaptol.beans.LeaveBean;
import com.hrmsNaaptol.beans.LoginBean;
import com.hrmsNaaptol.beans.RollBean;
import com.hrmsNaaptol.utils.CommonConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class CommonDao
{
	int count = 0;
	public ArrayList validate(LoginBean loginBean) throws SQLException
	{
		ArrayList list = new ArrayList();
		Connection con = CommonConnection.getConnection();
		try {
	
			
			PreparedStatement preparedStatement= con.prepareStatement("select pkempid,password, fkrollid,fname,lname from userdetails where pkempid = ? and password = ? ");
			preparedStatement.setLong(1, loginBean.getEmpid());
			preparedStatement.setString(2, loginBean.getPassword());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				
				list.add(rs.getLong(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				return list;
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
			return list;
		}
		finally
		{
			CommonConnection.closeConnection();
		}
		
		return list;
		
	}
	
	public ArrayList deptList() throws SQLException
	{
		
		ArrayList arrayList = new ArrayList();
		Connection con = CommonConnection.getConnection();
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement("select pkdepartmentid, deptname from department");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				
				
				Long pkdepartmentid =rs.getLong(1);
				String deptname= rs.getString(2);
				DepartmentBean departmentBean = new DepartmentBean(pkdepartmentid, deptname);
				arrayList.add(departmentBean);
				
			}
			
		}
		catch(Exception e)
		{

			e.printStackTrace();
		
		}
		finally
		{
			CommonConnection.closeConnection();
		}
		return arrayList;
		
		
		
		
	}

	public ArrayList rollList() throws SQLException
	{
		
		ArrayList arrayList = new ArrayList();
		Connection con = CommonConnection.getConnection();
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement("select pkrollid, rollname from roll");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				
				
				Long pkrollid =rs.getLong(1);
				String rollname= rs.getString(2);
				
				RollBean rollBean = new RollBean(pkrollid, rollname);
				arrayList.add(rollBean);
				
			}
			
		}
		catch(Exception e)
		{

			e.printStackTrace();
		
		}
		finally
		{
			CommonConnection.closeConnection();
		}
		return arrayList;
		
		
		
		
	}
	
	public int registerEmployee(EmployeeBean employeeBean ) throws SQLException
	{
		 int result = 0;
		Connection con = CommonConnection.getConnection();
		try
		{
			 String INSERT_USERS_SQL = "INSERT INTO userdetails" +
			            "  (fname, lname, dob, joiningdate, fkdeptid, fkrollid, mobileno,password,state,city,address,pincode) VALUES " +
			            " (?,?,?,?,?,?,?,?,?,?,?,?);";
			
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, employeeBean.getFname());
			preparedStatement.setString(2, employeeBean.getLname());
			preparedStatement.setString(3, employeeBean.getDob());
			preparedStatement.setString(4, employeeBean.getDoj());
			preparedStatement.setString(5, employeeBean.getDepartment());
			preparedStatement.setString(6, employeeBean.getRoll());
			preparedStatement.setString(7, employeeBean.getMobileno());
			preparedStatement.setString(8, employeeBean.getPassword());
			preparedStatement.setString(9, employeeBean.getState());
			preparedStatement.setString(10, employeeBean.getCity());
			preparedStatement.setString(11, employeeBean.getAddress());
			preparedStatement.setString(12, employeeBean.getPincode());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();

			return result;
		}
		catch(Exception e)
		{

			e.printStackTrace();
		
		}
		finally
		{
			CommonConnection.closeConnection();
		}
		
		return result;
		
	}
	
	public int applyLeave(LeaveBean leaveBean) throws SQLException
	{
		int result = 0;
		Connection con = CommonConnection.getConnection();
		try
		{
			 String INSERT_USERS_SQL = "INSERT INTO `leave`" +
			            "  (fkuserid, description, fromdate, todate, status) VALUES " +
			            " (?,?,?,?,?);";
			
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setLong(1, leaveBean.getEmpid());
			preparedStatement.setString(2, leaveBean.getDescription());
			preparedStatement.setString(3, leaveBean.getFromDate());
			preparedStatement.setString(4, leaveBean.getToDate());
			preparedStatement.setString(5, leaveBean.getAction());
			
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();

			return result;
		}
		catch(Exception e)
		{

			e.printStackTrace();
		
		}
		finally
		{
			CommonConnection.closeConnection();
		}
		
		return result;
	}
	
	
	public int updateEmployee(EmployeeBean employeeBean ) throws SQLException
	{
		 int result = 0;
		Connection con = CommonConnection.getConnection();
		try
		{
			 String INSERT_USERS_SQL = "UPDATE userdetails SET" +
			            "  fname = ?, lname= ?, dob = ? , joiningdate = ? , fkdeptid = ?, "
			            + "fkrollid = ?, mobileno = ? ,`password` = ?, state = ? , city= ? ,address=?, pincode = ? "
			            + "WHERE pkempid = ?;";
			
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, employeeBean.getFname());
			preparedStatement.setString(2, employeeBean.getLname());
			preparedStatement.setString(3, employeeBean.getDob());
			preparedStatement.setString(4, employeeBean.getDoj());
			preparedStatement.setString(5, employeeBean.getDepartment());
			preparedStatement.setString(6, employeeBean.getRoll());
			preparedStatement.setString(7, employeeBean.getMobileno());
			preparedStatement.setString(8, employeeBean.getPassword());
			preparedStatement.setString(9, employeeBean.getState());
			preparedStatement.setString(10, employeeBean.getCity());
			preparedStatement.setString(11, employeeBean.getAddress());
			preparedStatement.setString(12, employeeBean.getPincode());
			preparedStatement.setString(13, employeeBean.getPkempid());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();

			return result;
		}
		catch(Exception e)
		{

			e.printStackTrace();
		
		}
		finally
		{
			CommonConnection.closeConnection();
		}
		
		return result;
		
	}
	
	public ArrayList employeeDetails() throws SQLException
	{
		
		ArrayList<EmployeeBean> arrayList = new ArrayList<EmployeeBean>();
		Connection con = CommonConnection.getConnection();
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement("select pkempid,fname, lname, dob, joiningdate, deptname, rollname,mobileno,state,city,address,pincode from userdetails u inner join department d on u.fkdeptid = d.pkdepartmentid inner join roll r on  u.fkrollid = r.pkrollid");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				EmployeeBean employeeBean = new EmployeeBean();
				employeeBean.setPkempid(rs.getString(1));
				employeeBean.setFname(rs.getString(2));
				employeeBean.setLname(rs.getString(3));
				employeeBean.setDob(rs.getString(4));
				employeeBean.setDoj(rs.getString(5));
				employeeBean.setDepartment(rs.getString(6));
				employeeBean.setRoll(rs.getString(7));
				employeeBean.setMobileno(rs.getString(8));
				employeeBean.setState(rs.getString(9));
				employeeBean.setCity(rs.getString(10));
				employeeBean.setAddress(rs.getString(11));
				employeeBean.setPincode(rs.getString(12));
				arrayList.add(employeeBean);
			}
			
		}
		catch(Exception e)
		{

			e.printStackTrace();
		
		}
		finally
		{
			CommonConnection.closeConnection();
		}
		return arrayList ;
		}
	
	public ArrayList userDetails(String pkempid) throws SQLException
	{
		
		ArrayList<EmployeeBean> arrayList = new ArrayList<EmployeeBean>();
		Connection con = CommonConnection.getConnection();
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement("select pkempid,fname, lname, dob, joiningdate, deptname, rollname,mobileno,state,city,address,pincode from userdetails u inner join department d on u.fkdeptid = d.pkdepartmentid inner join roll r on  u.fkrollid = r.pkrollid where u.pkempid = ?;");
			preparedStatement.setString(1, pkempid);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				EmployeeBean employeeBean = new EmployeeBean();
				employeeBean.setPkempid(rs.getString(1));
				employeeBean.setFname(rs.getString(2));
				employeeBean.setLname(rs.getString(3));
				employeeBean.setDob(rs.getString(4));
				employeeBean.setDoj(rs.getString(5));
				employeeBean.setDepartment(rs.getString(6));
				employeeBean.setRoll(rs.getString(7));
				employeeBean.setMobileno(rs.getString(8));
				employeeBean.setState(rs.getString(9));
				employeeBean.setCity(rs.getString(10));
				employeeBean.setAddress(rs.getString(11));
				employeeBean.setPincode(rs.getString(12));
				arrayList.add(employeeBean);
			}
			
		}
		catch(Exception e)
		{

			e.printStackTrace();
		
		}
		finally
		{
			CommonConnection.closeConnection();
		}
		return arrayList ;
		}
	
	public ArrayList userLeave(String pkempid) throws SQLException
	{
		
		ArrayList arrayList = new ArrayList();
		Connection con = CommonConnection.getConnection();
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement("select fkuserid,description,fromdate,todate,status from `leave` where fkuserid = ?;");
			preparedStatement.setString(1, pkempid);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				LeaveBean leaveBean = new LeaveBean();
				leaveBean.setEmpid(rs.getLong(1));
				leaveBean.setDescription(rs.getString(2));
				leaveBean.setFromDate(rs.getString(3));
				leaveBean.setToDate(rs.getString(4));
				leaveBean.setAction(rs.getString(5));
				arrayList.add(leaveBean);
			}
			
		}
		catch(Exception e)
		{

			e.printStackTrace();
		
		}
		finally
		{
			CommonConnection.closeConnection();
		}
		return arrayList ;
		}
	
	
	public ArrayList employeeDetailList(String empdetail) throws SQLException
	{
		ArrayList arrayList = new ArrayList();
		Connection con = CommonConnection.getConnection();
	try
	{
		PreparedStatement preparedStatement = con.prepareStatement("select pkempid, fname, lname, dob, joiningdate, fkdeptid,fkrollid,mobileno,password,state,city,address,pincode from userdetails where pkempid = ?");
		preparedStatement.setString(1,empdetail);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next())
		{
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setPkempid(rs.getString(1));
			employeeBean.setFname(rs.getString(2));
			employeeBean.setLname(rs.getString(3));
			employeeBean.setDob(rs.getString(4));
			employeeBean.setDoj(rs.getString(5));
			employeeBean.setDepartment(rs.getString(6));
			employeeBean.setRoll(rs.getString(7));
			employeeBean.setMobileno(rs.getString(8));
			employeeBean.setPassword(rs.getString(9));
			employeeBean.setState(rs.getString(10));
			employeeBean.setCity(rs.getString(11));
			employeeBean.setAddress(rs.getString(12));
			employeeBean.setPincode(rs.getString(13));
			arrayList.add(employeeBean);
		}
		
	}
	catch(Exception e)
	{

		e.printStackTrace();
	
	}
	finally
	{
		CommonConnection.closeConnection();
	}
	return arrayList ;
	}
	
	public int addAttendance(String pkempid) throws SQLException
	{
		int result = 0;
		
		Calendar calobj = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		LocalTime now = LocalTime.now();
		LocalTime limit = LocalTime.parse( "09:30:00" );
		Boolean isLate = now.isAfter( limit );
		Connection con = CommonConnection.getConnection();
		if(isIntimeSet(pkempid))
		{
		try
		{
			
			 String INSERT_USERS_SQL = "update attendance set intime=? , latemark=? WHERE fkempid = ? and date = ?;";
			
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			
			preparedStatement.setString(1, dateFormat.format(calobj.getTime()));
			preparedStatement.setBoolean(2, isLate);
			preparedStatement.setString(3, pkempid);
			preparedStatement.setString(4, df.format(calobj.getTime()));
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
			

		
		}
		catch(Exception e)
		{

			e.printStackTrace();
		
		}
		finally
		{
			CommonConnection.closeConnection();
		}
		
		return result;
		}
		else 
		{
			try
			{
				Connection con2 = CommonConnection.getConnection();
			String one = dateFormat.format(calobj.getTime());
			String UPDATE_TIMEOUT = "UPDATE attendance SET outtime = ? Where fkempid = ? ;";
			PreparedStatement preparedStatement = con2.prepareStatement(UPDATE_TIMEOUT);
			preparedStatement.setString(1, dateFormat.format(calobj.getTime()));
			preparedStatement.setString(2, pkempid);
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
			}
			catch(Exception e)
			{

				e.printStackTrace();
			
			}
			finally
			{
				CommonConnection.closeConnection();
			}
		}
		return result;
		
	}
	
	
	public int setDateInOutTime(String pkempid) throws SQLException
	{
		int result = 0;
		
		Calendar calobj = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		LocalTime now = LocalTime.now();
		LocalTime limit = LocalTime.parse( "09:30:00" );
		Boolean isLate = now.isAfter( limit );
		Connection con = CommonConnection.getConnection();

		
		
		try
		{
			
			 String INSERT_USERS_SQL = "INSERT INTO attendance" +
			            "  (fkempid, date, shiftin, shiftout) VALUES " +
			            " (?,?,?,?);";
			
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, pkempid);
			preparedStatement.setString(2,df.format(calobj.getTime()));
			preparedStatement.setString(3,"9:30 AM" );
			preparedStatement.setString(4,"7:00 PM" );
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
			

		
		}
		catch(Exception e)
		{

			e.printStackTrace();
		
		}
		finally
		{
			CommonConnection.closeConnection();
		}
	return result;
		
		
		}
	
	
	public ArrayList getDateInOutTime(Long empid) throws SQLException
	{
		
		ArrayList arrayList = new ArrayList();
		Connection con = CommonConnection.getConnection();
		try
		{ 
			Calendar calobj = Calendar.getInstance();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(calobj.getTime());
			PreparedStatement preparedStatement = con.prepareStatement("SELECT  u.fname, a.date, a.shiftin,a.shiftout,a.intime,a.outtime,a.latemark,a.totalhours FROM userdetails u INNER JOIN attendance a ON a.fkempid = u.pkempid  WHERE a.fkempid = ? and a.date = ? limit 1;");
			preparedStatement.setLong(1,empid);
			preparedStatement.setString(2, date);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				AttendanceBean attendanceBean = new AttendanceBean();
				attendanceBean.setFname(rs.getString(1));
				attendanceBean.setDate(rs.getString(2));
				attendanceBean.setShiftin(rs.getString(3));
				attendanceBean.setShiftout(rs.getString(4));
				attendanceBean.setIntime(rs.getString(5));
				attendanceBean.setOuttime(rs.getString(6));
				attendanceBean.setLatemark(rs.getString(7));
				attendanceBean.setTotalhours(rs.getString(8));
				arrayList.add(attendanceBean);
			}
			
		}
		catch(Exception e)
		{

			e.printStackTrace();
		
		}
		finally
		{
			CommonConnection.closeConnection();
		}
		return arrayList ;
		}
	
	 public boolean isIntimeSet(String empid) throws SQLException 
	 {
		   boolean result = false;
		 	Connection con = CommonConnection.getConnection();
	 		Calendar calobj = Calendar.getInstance();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(calobj.getTime());
	        String query = "select intime from attendance where  ISNULL(intime)and date = ? and fkempid =?;";  
	        try {
	        
	    PreparedStatement preparedStatement = con.prepareStatement(query);
	    preparedStatement.setString(1, date);
	      preparedStatement.setString(2,empid);
	      ResultSet rs = preparedStatement.executeQuery();
	      if(rs.next()) {
	       return true ;
	      }else 
	      {
	       return false ;
	      }
	     } catch (SQLException e) 
	     {
	      e.printStackTrace();
	      
	     }
	        finally
			{
				CommonConnection.closeConnection();
			}
			return true;
	      }

}
