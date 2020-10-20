package com.hrmsNaaptol.beans;

public class RollBean 
{
	private Long pkrollid;
	private String rollname;
	
	public RollBean (Long pkrollid, String rollname)
	{
		super();
        this.pkrollid = pkrollid;
        this.rollname = rollname;
	}

	public Long getPkrollid() {
		return pkrollid;
	}

	public void setPkrollid(Long pkrollid) {
		this.pkrollid = pkrollid;
	}

	public String getRollname() {
		return rollname;
	}

	public void setRollname(String rollname) {
		this.rollname = rollname;
	}
	
	
}
