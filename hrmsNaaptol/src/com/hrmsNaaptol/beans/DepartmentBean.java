package com.hrmsNaaptol.beans;

public class DepartmentBean 
{
	private Long pkdepartmentid;
	private String deptname;
	
	public DepartmentBean(Long pkdepartmentid,String deptname)
	{
		super();
        this.pkdepartmentid = pkdepartmentid;
        this.deptname = deptname;
	}
	public Long getPkdepartmentid() {
		return pkdepartmentid;
	}
	public void setPkdepartmentid(Long pkdepartmentid) {
		this.pkdepartmentid = pkdepartmentid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	

}
