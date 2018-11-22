package com.yuansong.resource;

import java.util.Date;

import com.yuansong.form.RdsAdd;

public class RdsResource extends BaseResource {
	
	//实例ID
	private String instanceID;
	//所在地域，如华东1
	private String area;
	//数据库类型
	private String dbType;
	//外网地址
	private String internetIp;
	//外网端口
	private int internetPort;
	//内网地址
	private String intranetIp;
	//内网端口
	private int intranetPort;
	//过期日期
	private Date expirationDate;
	
	public RdsResource() {
		super();
	}
	
	public RdsResource(RdsAdd form) {
		super(form);
		this.instanceID = form.getInstanceID();
		this.area = form.getArea();
		this.dbType = form.getDbType();
		this.internetIp = form.getInternetIp();
		this.internetPort = form.getInternetPort();
		this.intranetIp = form.getIntranetIp();
		this.intranetPort = form.getIntranetPort();
		this.expirationDate = form.getExpirationDate();
	}
	
	@Override
	public String check() {
		StringBuilder sb = new StringBuilder(super.check());
		if(this.getInstanceID() == null || this.getInstanceID().equals("")) {
			sb.append("实例ID不允许为空；");
		}
		if(this.getArea()==null || this.getArea().equals("")) {
			sb.append("所在地域不允许为空；");
		}
		if(this.getDbType() == null || this.getDbType().equals("")) {
			sb.append("系统类型不能为空");
		}
		if(this.getInternetIp() == null || this.getInternetIp().equals("")) {
			sb.append("公网IP不允许为空；");
		}
		if(this.getIntranetIp() == null || this.getIntranetIp().equals("")){
			sb.append("私有IP不允许为空；");
		}
		return sb.toString();
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getInternetIp() {
		return internetIp;
	}
	public void setInternetIp(String internetIp) {
		this.internetIp = internetIp;
	}
	public String getIntranetIp() {
		return intranetIp;
	}
	public void setIntranetIp(String intranetIp) {
		this.intranetIp = intranetIp;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getInstanceID() {
		return instanceID;
	}
	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}
	public int getInternetPort() {
		return internetPort;
	}
	public void setInternetPort(int internetPort) {
		this.internetPort = internetPort;
	}
	public int getIntranetPort() {
		return intranetPort;
	}
	public void setIntranetPort(int intranetPort) {
		this.intranetPort = intranetPort;
	}

}
