package com.yuansong.resource;

import com.yuansong.form.RedisAdd;

public class RedisResource extends BaseResource {
	
	//实例ID
	private String instanceID;
	//所在地域，如华东1
	private String area;
	//连接地址
	private String host;
	//端口
	private int port;
	//连接密码
	private String pwd;
	
	
	public RedisResource() {
		super();
	}
	
	public RedisResource(RedisAdd form) {
		super(form);
		this.instanceID = form.getInstanceID();
		this.area = form.getArea();
		this.host = form.getHost();
		this.port = form.getPort();
		this.pwd = form.getPwd();
	}
	
	@Override
	public String check() {
		StringBuilder sb = new StringBuilder(super.check());
		if(this.instanceID == null || this.instanceID.equals("")) {
			sb.append("实例ID不允许为空；");
		}
		if(this.area == null || this.area.equals("")) {
			sb.append("所在区不能为空；");
		}
		if(this.host == null || this.host.equals("")) {
			sb.append("连接地址不允许为空；");
		}
		return sb.toString();
	}
	
	
	public String getInstanceID() {
		return instanceID;
	}
	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
