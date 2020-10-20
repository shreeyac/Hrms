package com.hrmsNaaptol.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.xml.internal.security.keys.content.RetrievalMethod;

import java.sql.Connection;

public class CommonConnection 
{
	static Connection connection = null;
	 public static Connection getConnection() throws SQLException  
	{
		
		try
		{
			
		Class.forName("com.mysql.jdbc.Driver");
		 connection = (Connection) DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/shreya", "root", "shreya");
		 System.out.println("Connection created");  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
		
	}
	 
	 public static void closeConnection() throws SQLException
	 {
		 if(connection !=null)
		 {
			 connection.close();
		 }
	 }
	
	 public static String toJSON(Object obj)
	{
		Gson gson = new GsonBuilder().create();
		
		return gson.toJson(obj);
		
	}
	

}
