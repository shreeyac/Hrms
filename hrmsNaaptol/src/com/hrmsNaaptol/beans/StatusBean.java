package com.hrmsNaaptol.beans;

public class StatusBean 
{
 private boolean status;
 private String message;
 private boolean isadmin;
 
 
public boolean isIsadmin() {
	return isadmin;
}
public void setIsadmin(boolean isadmin) {
	this.isadmin = isadmin;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
 
}
