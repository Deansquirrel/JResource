package com.yuansong.resource;

import com.yuansong.common.CommonFun;
import com.yuansong.form.MongoDBAdd;

public class MongoDBResource extends BaseResource {
	
	//公网IP
	private String internetIp;
	//私有IP
	private String intranetIp;
	
	private int port;
	private String loginName;
	private String loginPwd;
	
	public MongoDBResource() {
		super();
	}
	
	public MongoDBResource(MongoDBAdd form) {
		super();
		this.setId(CommonFun.UUID());
		this.setName(form.getName());
		this.setDescription(form.getDescription());
		this.setInternetIp(form.getInternetIp());
		this.setIntranetIp(form.getIntranetIp());
		this.setPort(form.getPort());
		this.setLoginName(form.getLoginName());
		this.setLoginPwd(form.getLoginPwd());
	}
	
	@Override
	public String check() {
		StringBuilder sb = new StringBuilder(super.check());
		if(this.getInternetIp() == null || this.getInternetIp().equals("")) {
			sb.append("外网地址不允许为空；");
		}
		if(this.getLoginName() == null || this.getLoginName().equals("")) {
			sb.append("登录名不允许为空；");
		}
		return sb.toString();
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
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

}
