package com.yuansong.resource;

import com.yuansong.form.RabbitMQAdd;

public class RabbitMQResource extends BaseResource {
	
	//公网IP
	private String internetIp;
	//私有IP
	private String intranetIp;
	
	private int port;
	private String loginName;
	private String loginPwd;
	
	
	public RabbitMQResource() {
		super();
	}
	
	public RabbitMQResource(RabbitMQAdd form) {
		super(form);
		this.setInternetIp(form.getInternetIp());
		this.setIntranetIp(form.getIntranetIp());
		this.setPort(form.getPort());
		this.setLoginName(form.getLoginName());
		this.setLoginPwd(form.getLoginPwd());
	}
	
	@Override
	public String check() {
		StringBuilder sb = new StringBuilder(super.check());
		if(this.internetIp == null || this.internetIp.equals("")) {
			sb.append("公网IP不允许为空；");
		}
		if(this.loginName == null || this.loginName.equals("")) {
			sb.append("登录名不允许为空；");
		}
		return sb.toString();
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
	public String getIntranetIp() {
		return intranetIp;
	}
	public void setIntranetIp(String intranetIp) {
		this.intranetIp = intranetIp;
	}
	public String getInternetIp() {
		return internetIp;
	}
	public void setInternetIp(String internetIp) {
		this.internetIp = internetIp;
	}

}
